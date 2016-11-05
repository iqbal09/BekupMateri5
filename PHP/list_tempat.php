<?php
/*
 * kode untuk tampilak semua produk, pada halaman home
 */

$response = array();


// include db connect class
require_once __DIR__ . '/db_connect.php';

// ckonekin ke db
$db = new DB_CONNECT();



		//  get by tempat
		$result = mysql_query("SELECT * FROM tempat ") or die(mysql_error());

		// cek
		if (mysql_num_rows($result) > 0) {
		    // looping hasil
		    // tempat node
		    $response["tempat"] = array();
		    
		    while ($row = mysql_fetch_array($result)) {
			$tempat = array();
			
					
			$tempat["id_db"] 			= $row["id_db"];
			$tempat["nama"] 			= $row["nama_tempat"];
			$tempat["koordinat"] 	= $row["kordinat"];
		
			// masukan tempat pada $response
			array_push($response["tempat"], $tempat);
		    }
		    // sukses
		    $response["success"] = 1;

		    // echo JSON response
		    echo json_encode($response);
		} else {
		    $response["success"] = 0;
		    $response["message"] = "Tidak ada data yang ditemukan";

		    echo json_encode($response);
		}







?>
