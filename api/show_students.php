<?php

include 'connection.php';

//if($con) echo ' success Connection';

$faculty = $_POST['faculty'];
$batch = $_POST['batch'];
//$batch = "12th Batch";

$sql = "SELECT * FROM student_registration WHERE faculty='$faculty' && batch='$batch'";

$res = mysqli_query($con,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
				"name"=>$row["name"],
				"Id_no"=>$row["Id_no"],
				"reg_no"=>$row["reg_no"],
				"pass"=>$row["pass"],
				"faculty"=>$row["faculty"],
				"batch"=>$row["batch"],
				"contact"=>$row["contact"],
				"email"=>$row["email"]
			)
		);
	}
	echo json_encode(array("result"=>$result));

?>