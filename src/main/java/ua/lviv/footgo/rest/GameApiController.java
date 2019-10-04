
package ua.lviv.footgo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.lviv.footgo.entity.Game;
import ua.lviv.footgo.entity.Goal;
import ua.lviv.footgo.entity.Player;
import ua.lviv.footgo.entity.Team;
import ua.lviv.footgo.repository.GameRepository;
import ua.lviv.footgo.repository.GoalRepository;
import ua.lviv.footgo.repository.TeamRepository;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping(path = "/api/game")
public class GameApiController {

    @Autowired
    GameRepository gameRepository;

    @Autowired
    TeamRepository teamRepository;

    @Autowired
    GoalRepository goalRepository;

    @DeleteMapping(value = "/clear", consumes = "application/json", produces = "application/json")
    public void clear() {
        Iterable<Game> gameList = gameRepository.findAll();
        for (Game game : gameList) {
            game.getTeamAGoals().clear();
            game.getTeamBGoals().clear();
            gameRepository.save(game);
        }
        goalRepository.deleteAll();

    }

    @GetMapping("/{id}")
    public Game getTeam(@PathVariable Long id) {
        return gameRepository.findById(id).get();
    }


    @GetMapping(value = "/all", consumes = "application/json", produces = "application/json")
    public List<Game> getResults() {
        return (List<Game>) gameRepository.findAll();
    }

    @GetMapping(value = "/team", consumes = "application/json", produces = "application/json")
    public List<Game> getResults(@RequestParam Long teamId) {
        Team team = teamRepository.findById(teamId).get();
        List<Game> homeGames = gameRepository.findByFirstTeamAndIsCompleted(team, true);
        List<Game> guestGames = gameRepository.findBySecondTeamAndIsCompleted(team, true);
        List<Game> allGames = Stream.concat(homeGames.stream(), guestGames.stream())
                .collect(Collectors.toList());
        Collections.sort(allGames, new Game.SortByTour());
        return allGames;
    }

    @PostMapping(value = "/{id}/goal", consumes = "application/json", produces = "application/json")
    public Goal addGoal(@PathVariable Long id, @RequestParam Player playerId, @RequestParam int goalMinute, @RequestParam boolean homeTeamGoal) {
        Game game = gameRepository.findById(id).get();
        Goal goal = new Goal();
        goal.setPlayer(playerId);
        goal.setTime(goalMinute);
        goal.setGame(game);
        if (homeTeamGoal) {
            game.addGoalForFirstTeam(goal);
        } else {
            game.addGoalForSecondTeam(goal);
        }
        goalRepository.save(goal);
        gameRepository.save(game);
        return goal;
    }

    @DeleteMapping(value = "/{gameId}/goal/{goalId}", consumes = "application/json", produces = "application/json")
    public void deleteGoal(@PathVariable Long goalId, @PathVariable Long gameId, @RequestParam Boolean isHomeTeamGoal) {
        Game game = gameRepository.findById(gameId).get();
        Goal goal = goalRepository.findById(goalId).get();
        if (isHomeTeamGoal) {
            game.removeGoalForFirstTeam(goal);
        } else {
            game.removeGoalForSecondTeam(goal);
        }
        gameRepository.save(game);
        goalRepository.delete(goal);
    }

    @PostMapping(value = "/{gameId}/completed/{isCompleted}", consumes = "application/json", produces = "application/json")
    public void markCompleted(@PathVariable Long gameId, @PathVariable boolean isCompleted) {
        Game game = gameRepository.findById(gameId).get();
        game.setCompleted(isCompleted);
        gameRepository.save(game);
    }

    @PostMapping(value = "/{gameId}/setgametime/{timeGame}", consumes = "application/json", produces = "application/json")
    public void setGameTime(@PathVariable Long gameId, @PathVariable String timeGame) {
        Game game = gameRepository.findById(gameId).get();
        game.setGameTime(timeGame);
        gameRepository.save(game);
    }

    @PutMapping(value = "/{gameId}/setvideourl", consumes = "application/json", produces = "application/json")
    public void setVideoUrl(@PathVariable Long gameId, @RequestParam String videoUrl) {
        Game game = gameRepository.findById(gameId).get();
        game.setVideoUrl(videoUrl);
        gameRepository.save(game);
    }
}
