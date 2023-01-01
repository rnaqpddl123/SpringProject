<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<title>File Upload</title>
	<style>
		img { 
		height: 200px;
		width: 200px;
		}
	</style>
</head>
<body>
	<h3>File Upload</h3>
	<hr>
	<form action="/file/upload" method="post" enctype="multipart/form-data">
		<h4>파일 선택(다중 선택 가능)</h4>
		메세지: <input type="text" name="msg"><br>
		<!-- 파일: <input type="file" name="files" multiple><br> -->
		파일: <input style="display: block;" type="file" id="input-multiple-image" name="files" multiple><br>
		<div id="multiple-container">
		</div>
		<input type="submit" value="업로드">
	</form>

	
	
	<script>
	function readMultipleImage(input) {
	    const multipleContainer = document.getElementById("multiple-container")
	    
	    // 인풋 태그에 파일들이 있는 경우
	    if(input.files) {
	        // 이미지 파일 검사 (생략)
	        console.log(input.files)
	        // 유사배열을 배열로 변환 (forEach문으로 처리하기 위해)
	        const fileArr = Array.from(input.files)
	        const $colDiv1 = document.createElement("td")
	        $colDiv1.classList.add("row")
	        fileArr.forEach((file, index) => {
	            const reader = new FileReader()
	            /* const $imgDiv = document.createElement("div")  */  
	            const $img = document.createElement("img")
	            $img.classList.add("image")
	            const $label = document.createElement("label")
	            $label.classList.add("image-label")
	            /* $label.textContent = file.name */
	            /* $imgDiv.appendChild($img) */
	            $img.appendChild($label)
	            reader.onload = e => {
	                $img.src = e.target.result
	              /*   $imgDiv.style.width = ($img.naturalWidth) * 0.2 + "px"
	                $imgDiv.style.height = ($img.naturalHeight) * 0.2 + "px" */
	                $img.style.width = "200px"
	                $img.style.height = "200px"
	            }
	            
	            console.log(file.name)
	            $colDiv1.appendChild($img)
	            reader.readAsDataURL(file)
	        })
	        multipleContainer.appendChild($colDiv1)
	    }
	}
	const inputMultipleImage = document.getElementById("input-multiple-image")
	inputMultipleImage.addEventListener("change", e => {
	    readMultipleImage(e.target)
	})
	</script>
	
</body>
</html>