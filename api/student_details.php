<?php

include 'connection.php';

//if($con) echo ' success Connection';

$Id_no = $_POST['Id_no'];

//$batch = "12th Batch";

$sql = "SELECT * FROM student_registration WHERE Id_no='$Id_no'";

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