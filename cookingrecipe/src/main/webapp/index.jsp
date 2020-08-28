<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
<style>
* {
  box-sizing: border-box;
}

body {
  font-family: Arial;
  padding: 10px;
  background: #e9d8f4;
}

/* Header/Blog Title */
.header {
  padding: 10px;
  text-align: center;
  background: white;
  color: #35257b;
}

.header h1 {
  font-size: 40px;
}

.header p {
  font-size: 20px;
}

/* Style the top navigation bar */
.topnav {
  overflow: hidden;
  background-color: #58257b;
}

/* Định dạng link điều hướng */
.topnav a {
  float: left;
  display: block;
  color: #ebf3ed;
  text-align: center;
  padding: 14px 16px;
  text-decoration: none;
}

/* Thay đổi màu liên kết khi di chuột qua */
.topnav a:hover {
  background-color: #db7093;
  color: white;
}

/* Tạo hai cột không bằng nhau, float cạnh nhau */
/* Cột trái */
.leftcolumn { 
  float: left;
  width: 75%;
}

/* Cột phải */
.rightcolumn {
  float: left;
  width: 25%;
  background-color: #e9d8f4;
  padding-left: 20px;
}

/* Hình ảnh tượng trưng */
.fakeimg {
  background-color: #8edde2;
  width: 100%;
  padding: 20px;
}

/* Thêm định dạng thẻ cho bài viết */
.card {
  background-color: white;
  padding: 20px;
  margin-top: 20px;
}

/* Clear float khác sau các cột */
.row:after {
  content: "";
  display: table;
  clear: both;
}

/* Footer */
.footer {
  padding: 10px;
  text-align: center;
  background: white;
  margin-top: 10px;
}
.button {
  background-color: rgb(42, 85, 202);
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}

.button2 {background-color: LightSalmon;}
.button3 {background-color: SeaGreen;} 
.button4 {background-color: MidnightBlue;} 
.button5 {background-color: Indigo;}
/* Bố cục linh hoạt: các cột xếp chồng lên nhau thay vì cạnh nhau khi màn hình 
có chiều rộng dưới 700px */
@media screen and (max-width: 700px) {
  .leftcolumn, .rightcolumn { 
    width: 100%;
    padding: 0;
  }
}

/* Bố cục linh hoạt: Thanh menu điều hướng xếp chồng lên nhau thay vì cạnh nhau
khi màn hình có chiều rộng dưới 300px  */
@media screen and (max-width: 300px) {
  .topnav a {
    float: none;
    width: 100%;
  }
}
</style>
</head>
<body>

<div class="header">
  <h1>Cooking Recipe</h1>
  <p>Công thức nấu ăn ngon</p>
</div>
<div class="box">
  <div class="container-1">
      <span class="icon"><i class="fa fa-search"></i></span>
      <input type="search" id="search" placeholder="Search..." />
  </div>
</div>
<div class="topnav">

  <a href="#">Ăn sáng</a>
  <a href="#">Ăn trưa</a>
  <a href="#">Ăn tối</a>
  <a href="#">Ăn kiêng</a>
  <a href="#">Đồ uống</a>
  <a href="#">Đồ ăn vặt</a>
  <a href="#">Đồ ăn nhanh</a>
  <a href="#" style="float:right">Đăng nhập</a>
  <a href="#" style="float:right">Đăng ký</a>

</div>

<div class="row">
  <div class="leftcolumn">
    <div class="card">
      <h2>Gà rang muối</h2>
      <h5>27/08/2020</h5>
<img border="0" src="https://i.ytimg.com/vi/HQcB166q9Uc/maxresdefault.jpg" width="300px" height="200px">
			<br></br>      
    </div>
    <div class="card">
      <h2>Bánh mochi nhân phô mai chiên</h2>
      <h5>26/08/2020</h5>
<img border="0" src="https://img-global.cpcdn.com/recipes/2ab8a8e210ae9a68/1200x630cq70/photo.jpg" width="300px" height="200px">
			<br></br>      
    </div>
  </div>
  <div class="rightcolumn">
    <div class="card">
      <h2>Giới thiệu</h2>
      <div class="fakeimg" style="height:100px;">Ảnh</div>
      <p>Cooking Recipe là một trang web hữu ích giúp bạn tìm kiếm và học hỏi được những công thức nấu ăn ngon </p>
    </div>
    <div class="card">
      <h3>Nổi bật</h3>
      <div class="fakeimg"><p>Ảnh</p></div>
      <div class="fakeimg"><p>Ảnh</p></div>
      <div class="fakeimg"><p>Ảnh</p></div>
    </div>
    <div class="card">
      <h3>Follow Us</h3>
<button class="button">Facebook</button>

    </div>
  </div>
</div>

<div class="footer">
  <h4>CookingRecipe.com</h4>
</div>

</body>
</html>