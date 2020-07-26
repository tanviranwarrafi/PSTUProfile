<?php

include 'connection.php';

//if($con) echo ' success Connection';

$faculty = $_POST['faculty'];
$semester = $_POST['semester'];

//$faculty = "Agriculture";
//$semester = "Semester-I";

$sql = "SELECT * FROM course_entry WHERE faculty='$faculty' && semester='$semester'";

$res = mysqli_query($con,$sql);

$result = array();

while($row = mysqli_fetch_array($res)){
		array_push($result,array(
				"course_title"=>$row["course_title"],
				"course_code"=>$row["course_code"],
				"credit"=>$row["credit"],
				"faculty"=>$row["faculty"],
				"semester"=>$row["semester"]
			)
		);
	}
	echo json_encode(array("result"=>$result));

?>