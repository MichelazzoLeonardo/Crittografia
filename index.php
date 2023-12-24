<!DOCTYPE html>
<html lang="en">
<head>
    <title>Home</title>
    <link rel="stylesheet" type="text/css" href="style/style.css">
</head>
<body>

<div class="encrypt container">
    <h3 class="title encrypt">Encrypt</h3>
    <form action="pages/encrypt/vigenere-form.php" method="post">
        <input type="submit" class="encrypt button submit" value="Vigenere">
    </form>
</div>



<div class="decrypt container">
    <h3 class="title encrypt">Decrypt</h3>
    <form action="pages/decrypt/vigenere-calc.php" method="post">
        <input type="submit" class="decrypt button submit" value="Vigenere">
    </form>
</div>

</body>
</html>