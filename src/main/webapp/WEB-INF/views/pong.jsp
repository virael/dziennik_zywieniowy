<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Pong</title>
    <style>
        body {
            margin: 0;
            padding: 0;
            display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
            background-color: darkgray;
        }

        canvas {
            border: solid 3px white;
        }
    </style>
    <link rel="stylesheet" href="">
</head>

<body>
    <canvas></canvas>
    <script>
        //wybieramy canvas
        const canvas = document.querySelector('canvas');
        const ctx = canvas.getContext('2d');

        canvas.height = 500;
        canvas.width = 1000;

        const ch = canvas.height;
        const cw = canvas.width;

        const ballSize = 20;
        let ballX = cw / 2 - ballSize / 2;
        let ballY = ch / 2 - ballSize / 2;

        const paddleWidth = 20;
        const paddleHeight = 100;

        const playerX = 70;
        const aiX = 910;

        let playerY = 200;
        let aiY = 200;

        const middleLineWidth = 6;
        const middleLineHeight = 16;

        let ballSpeedX = 1;
        let ballSpeedY = 1;

        //funkcja tworząca paletkę gracza
        function player() {
            ctx.fillStyle = '#2222c3';
            ctx.fillRect(playerX, playerY, paddleWidth, paddleHeight);
        }
        //funkcja tworząca paletkę AI
        function AI() {
            ctx.fillStyle = '#d02828';
            ctx.fillRect(aiX, aiY, paddleWidth, paddleHeight);
        }
        //funkcja tworząca piłkę
        function ball() {
            ctx.fillStyle = '#ffffff';
            ctx.fillRect(ballX, ballY, ballSize, ballSize);
            ballX += ballSpeedX;
            ballY += ballSpeedY; // piłka leci na skos
            if (ballY <= 0 || ballY >= ch - ballSize) {
                ballSpeedY = -ballSpeedY;
                speedUp();
            }
            if (ballX <= 0 || ballX >= cw - ballSize) {
                ballSpeedX = -ballSpeedX;
                speedUp();
            }
        }
        //funkcja okrewślająca kolor gry
        function table() {
            //Stół
            //kolor stołu
            ctx.fillStyle = 'black';
            //wypełnienie stołu <wartość początkowa x, y wartość klońcowa x,y
            ctx.fillRect(0, 0, cw, ch);
            for (let linePosition = 20; linePosition < ch; linePosition += 30) {
                ctx.fillStyle = 'grey';
                ctx.fillRect(cw / 2 - middleLineWidth / 2, linePosition, middleLineWidth, middleLineHeight);
            }
        }

        topCanvas = canvas.offsetTop;
        //console.log(topCanvas);

        function playerPosition(e) {
            playerY = e.clientY - topCanvas - paddleHeight / 2;

            if (playerY <= 0) {
                playerY = 0;
            }

            if (playerY >= ch - paddleHeight) {
                playerY = ch - paddleHeight;
            }

            // aiY = playerY;

        };

        function collisionDetection() {
            if (ballX <= playerX + paddleWidth && ballY + ballSize >= playerY && ballY <= playerY + paddleHeight && ballX >= playerX) {
                console.log("ciach");
                ballSpeedX = -ballSpeedX;
            }
            if (ballX + ballSize >= aiX && ballY + ballSize >= aiY && ballY <= aiY + paddleHeight && ballX + ballSize <= aiX + paddleWidth) {
                console.log("ciach AI");
                ballSpeedX = -ballSpeedX;
            }
        };

        function aiPosition() {
            const middleAiPaddle = aiY + paddleHeight / 2;
            const middleBall = ballY + ballSize / 2;
            const aiMove = middleAiPaddle - middleBall;
            //console.log("pozycja Y paletki to: " + middleAiPaddle);

            if (ballX >= 500) {
                if (middleAiPaddle - middleBall > 200) {
                    //console.log("tutaj >200")
                    aiY -= 20;
                } else if (middleAiPaddle - middleBall > 50) {
                    //console.log("tutaj >50")
                    aiY -= 10;
                } else if (middleAiPaddle - middleBall < -200) {
                    //console.log("tutaj <-200")
                    aiY += 20;
                } else if (middleAiPaddle - middleBall < -50) {
                    //console.log("tutaj <-50")
                    aiY += 10;
                }

            } else if (ballX < 500 && ballX >= 150) {
                if (middleAiPaddle - middleBall > 100) {
                    aiY -= 3;
                    //console.log("srutututu")
                } else if (middleAiPaddle - middleBall < -100)
                    aiY += 3;
            }

            if (aiY <= 0) {
                aiY = 0;
            } else if (aiY >= ch - paddleHeight) {
                aiY = ch - paddleHeight;
            }
        }

        function speedUp() {
            //console.log(ballSpeedX + ", " + ballSpeedY);
            if (ballSpeedX > 0 && ballSpeedX < 10) {
                ballSpeedX += 1;
            } else if (ballSpeedX < 0 && ballSpeedX > -10) {
                ballSpeedX -= 1;
            }

            if (ballSpeedY > 0 && ballSpeedY < 10) {
                ballSpeedY += 1;
            } else if (ballSpeedY < 0 && ballSpeedY > -10) {
                ballSpeedY -= 1;
            }

        }

        canvas.addEventListener("mousemove", playerPosition);


        function game() {
            table() //wywołanie funkcji
            ball()
            player()
            AI()
            aiPosition()
            collisionDetection()
        }
        setInterval(game, 1000 / 60);
    </script>
</body>
</html>
