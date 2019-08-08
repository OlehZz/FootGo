package ua.lviv.footgo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "game")
public class Game {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String gameTime;
    @Column
    private String location;

    @OneToOne
    private Team firstTeam;

    @OneToOne
    private Team secondTeam;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Goal> teamAGoals;

    @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
    private List<Goal> teamBGoals;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Tour tour;

    public boolean hasTeamAWin(){
        if(this.teamAGoals == null) {
            this.teamAGoals = new ArrayList<>();
        }
        if(this.teamBGoals == null) {
            this.teamBGoals = new ArrayList<>();
        }
        return  teamAGoals.size() > teamBGoals.size();
    }

    public boolean hasTeamBWin(){
        if(this.teamAGoals == null) {
            this.teamAGoals = new ArrayList<>();
        }
        if(this.teamBGoals == null) {
            this.teamBGoals = new ArrayList<>();
        }
        return  teamAGoals.size() < teamBGoals.size();
    }

    public boolean isADraw() {
        return teamAGoals.size() == teamBGoals.size();
    }


    public String getGameTime() {
        return gameTime;
    }

    public void setGameTime(String gameTime) {
        this.gameTime = gameTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public List<Goal> getTeamAGoals() {
        return teamAGoals;
    }

    public void setTeamAGoals(List<Goal> teamAGoals) {
        this.teamAGoals = teamAGoals;
    }

    public List<Goal> getTeamBGoals() {
        return teamBGoals;
    }

    public void setTeamBGoals(List<Goal> teamBGoals) {
        this.teamBGoals = teamBGoals;
    }

    public Long getId() {
        return id;
    }

    public void addGoalForFirstTeam(Goal goal) {
        if(this.teamAGoals == null) {
            this.teamAGoals = new ArrayList<>();
        }
        this.teamAGoals.add(goal);
    }

    public void addGoalForSecondTeam(Goal goal) {
        if(this.teamBGoals == null) {
            this.teamBGoals = new ArrayList<>();
        }
        this.teamBGoals.add(goal);
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

}