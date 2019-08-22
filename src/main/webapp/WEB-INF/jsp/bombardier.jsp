<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width">
    <title>Бомбардири</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="style.css">
    <link rel="shortcut icon" href="img/footgo-dark-icon.png" type="image/x-icon">
    <link rel="stylesheet" href="hamburger.css">

</head>
<body>
<header>
    <div class="header-full">
        <div class="header-first-block">
            <div class="header-icon">
                <a href="/"><img class="header-img" src="img/footgo-light-icon.png" alt="wiselogo"></a>
            </div>
            <div class="header-null">
                <a href="javascript:void(0);" class="icon" onclick="myFunction()">
                    <i class="hamburger fa fa-bars"></i>
                </a>
            </div>


            <div class="header-text">
                <a href="/signup"><p>Реєстрація</p></a>
                <a href="/results"><p>Результати</p></a>
                <a href="/gametable"><p>Таблиця</p></a>
                <a href="/bombardier"><p>Бомбардири</p></a>
            </div>
        </div>

    </div>
    <div id="myLinks">
        <div><a class="link-item" href="/signup">Реєстрація</a></div>
        <div><a class="link-item" href="/results">Результати</a></div>
        <div><a class="link-item" href="/gametable">Таблиця</a></div>
        <div><a class="link-item" href="/bombardier">Бомбардири</a></div>
    </div>
</header>

<div class="bomb-full">
    <div class="bomb-head">
        <p>Кращі бомбардири турніру</p>
    </div>

    <div class="bomb">
        <div class="bomb-position">
            <div class="bomb-title">№</div>
            <div class="bomb-firstplace">1</div>
            <div class="bomb-secondplace">2</div>
            <div class="bomb-thirdplace">3</div>
            <div>4</div>
            <div>5</div>
            <div>6</div>
            <div>7</div>
            <div>8</div>
            <div>9</div>
            <div>10</div>
        </div>
        <div class="bomb-player-name">
            <div class="bomb-title">Футболіст</div>
            <div class="bomb-firstplace"><p>не заявлена</p></div>
            <div class="bomb-secondplace"><p>не заявлена</p></div>
            <div class="bomb-thirdplace"><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
            <div><p>не заявлена</p></div>
        </div>
        <div class="bomb-scored">
            <div class="bomb-title">М'ячів</div>
            <div class="bomb-firstplace">0</div>
            <div class="bomb-secondplace">0</div>
            <div class="bomb-thirdplace">0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
        </div>
        <div class="bomb-scored-pen">
            <div class="bomb-title">М'ячів (пен)</div>
            <div class="bomb-firstplace">0</div>
            <div class="bomb-secondplace">0</div>
            <div class="bomb-thirdplace">0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
        </div>
        <div class="bomb-matches">
            <div class="bomb-title">Ігор</div>
            <div class="bomb-firstplace">0</div>
            <div class="bomb-secondplace">0</div>
            <div class="bomb-thirdplace">0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
        </div>
        <div class="bomb-team">
            <div class="bomb-title">Команда</div>
            <div class="bomb-firstplace">0</div>
            <div class="bomb-secondplace">0</div>
            <div class="bomb-thirdplace">0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
            <div>0</div>
        </div>


    </div>




</div>

<script src="signUpScript.js"></script>
<script src="hamburger.js"></script>


</body>
</html>