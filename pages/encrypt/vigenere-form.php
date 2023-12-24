<!DOCTYPE html>
<html lang="en">
<head>
    <title>Encrypt - Vigenere</title>
    <link rel="stylesheet" type="text/css" href="../../style/style.css">
</head>
<body>
<form action="vigenere-calc.php" method="post">
    <label class="label">
        Messaggio in chiaro:
        <input type="text" class="input message" name="msg" placeholder="Write here" required autofocus>
    </label><br>
    <label class="label">
        Chiave:
        <input type="number" class="input number" name="key1" placeholder="#" required>
        <input type="number" class="input number" name="key2" placeholder="#" required>
        <input type="number" class="input number" name="key3" placeholder="#" required>
        <input type="number" class="input number" name="key4" placeholder="#" required>
        <input type="hidden" name="length" value="4">
    </label><br>
    <input type="submit" class="button" value="GO">
</form>
<form action="../../index.php" method="post">
    <input type="submit" class="button" value="<<<">
</form>
</body>
</html>