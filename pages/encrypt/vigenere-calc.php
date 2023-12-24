<!DOCTYPE html>
<html lang="en">
<head>
    <title>Result</title>
    <link rel="stylesheet" type="text/css" href="../../style/style.css">
    <script>
        function copy() {
            let copyText = document.getElementById("text");
            copyText.select();
            navigator.clipboard.writeText(copyText.value);
            alert("Testo copiato!");
        }
    </script>
</head>
<body>

<?php
$result = '';
if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $key_length = $_POST['length'];
    $msg = $_POST['msg'];
    $key = array(
        $_POST['key1'],
        $_POST['key2'],
        $_POST['key3'],
        $_POST['key4']
    );

    $chars = str_split($msg);
    $index = 0;
    foreach ($chars as $char) {
        $ascii = ord($char) + $key[$index];
        $result .= chr($ascii);
        $index = ($index + 1) % $key_length;
    }
}
?>

<label class="label">Frase criptata:
    <input type="text" class="input text" id="text" value=<?php echo(!empty($result)) ? '"'.$result.'"' : '"%ERROR%"'.'style="color: red"'; echo "readonly";?> >
    <input type="button" class="input button" value="+" onclick="copy()">
</label><br>

<form action="vigenere-form.php" method="post">
    <input type="submit" class="button" value="INDIETRO">
</form>
</body>
</html>