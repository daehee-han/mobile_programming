<?php
  error_reporting(E_ALL & ~(E_NOTICE | E_WARNING));

  $con=mysqli_connect("127.0.0.1","root","autoset","login");

  $userID = $_POST["userID"];
  $userPassword = $_POST["userPassword"];
  $userName = $_POST["userName"];
  $userRoomNumber = $_POST["userRoomNumber"];

  $statement = mysqli_prepare($con, "INSERT INTO USER VALUES (?, ?, ?, ?)");
  mysqli_stmt_bind_param($statement, "sssi", $userID, $userPassword, $userName, $userRoomNumber);
  mysqli_stmt_execute($statement);

  $response = array();
  $response["success"] = true;

  echo json_encode($response);
?>
