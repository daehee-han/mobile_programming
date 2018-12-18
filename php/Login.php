<?php

$con=mysqli_connect("127.0.0.1","root","autoset","login");

$userID = $_POST["userID"];
$userPassword = $_POST["userPassword"];

$statement = mysqli_prepare($con, "SELECT * FROM USER WHERE userID = ? AND userPassword = ?");
mysqli_stmt_bind_param($statement, "ss", $userID, $userPassword);
mysqli_stmt_execute($statement);

mysqli_stmt_store_result($statement);
mysqli_stmt_bind_result($statement, $userID, $userPassword, $userName, $userRoomNumber);

$response = array();
$response["success"] = false;

while(mysqli_stmt_fetch($statement)){
  $response["success"] = true;
  $response["userID"] = $userID;
  $response["userPassword"] = $userPassword;
  $response["userName"] = $userName;
  $response["userRoomNumber"] = $userRoomNumber;
}

echo json_encode($response);
?>
