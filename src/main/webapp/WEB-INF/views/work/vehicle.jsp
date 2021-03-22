<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/include/adminhead.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<body class=" ">
  <div class="wrapper ">
    <div class="sidebar">
      <!--
        Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
    -->
      <div class="sidebar-wrapper">
        <div class="logo">
          <a href="http://www.creative-tim.com" class="simple-text logo-mini">
            CT
          </a>
          <a href="http://www.creative-tim.com" class="simple-text logo-normal">
            Creative Tim
          </a>
        </div>
        <ul class="nav">
          <li class="active ">
            <a href="./dashboard.html">
              <i class="tim-icons icon-chart-pie-36"></i>
              <p>Dashboard</p>
            </a>
          </li>
          <li>
            <a href="./icons.html">
              <i class="tim-icons icon-atom"></i>
              <p>Icons</p>
            </a>
          </li>
          <li>
            <a href="./map.html">
              <i class="tim-icons icon-pin"></i>
              <p>Maps</p>
            </a>
          </li>
          <li>
            <a href="./notifications.html">
              <i class="tim-icons icon-bell-55"></i>
              <p>Notifications</p>
            </a>
          </li>
          <li>
            <a href="./user.html">
              <i class="tim-icons icon-single-02"></i>
              <p>User Profile</p>
            </a>
          </li>
          <li>
            <a href="./tables.html">
              <i class="tim-icons icon-puzzle-10"></i>
              <p>Table List</p>
            </a>
          </li>
          <li>
            <a href="./typography.html">
              <i class="tim-icons icon-align-center"></i>
              <p>Typography</p>
            </a>
          </li>
          <li>
            <a href="./rtl.html">
              <i class="tim-icons icon-world"></i>
              <p>RTL Support</p>
            </a>
          </li>
        </ul>
      </div>
    </div>
    <div class="main-panel">
      <!-- Navbar -->
      <nav class="navbar navbar-expand-lg navbar-absolute navbar-transparent   ">
        <div class="container-fluid">
          <div class="navbar-wrapper">
            <div class="navbar-toggle d-inline">
              <button type="button" class="navbar-toggler">
                <span class="navbar-toggler-bar bar1"></span>
                <span class="navbar-toggler-bar bar2"></span>
                <span class="navbar-toggler-bar bar3"></span>
              </button>
            </div>
            <a class="navbar-brand" href="#pablo">Dashboard</a>
          </div>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
            <span class="navbar-toggler-bar navbar-kebab"></span>
          </button>
          <div class="collapse navbar-collapse" id="navigation">
            <ul class="navbar-nav ml-auto ">
              <div class="search-bar input-group">
                <!-- <input type="text" class="form-control" placeholder="Search...">
      <div class="input-group-addon"><i class="tim-icons icon-zoom-split"></i></div> -->
                <button class="btn btn-link" id="search-button" data-toggle="modal" data-target="#searchModal"><i class="tim-icons icon-zoom-split"></i></button>
                <!-- You can choose types of search input -->
              </div>
              <!-- <div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal" aria-hidden="true">
    <div class="modal-dialog" role="document">
      <div class="modal-content">
        <div class="modal-header">
          <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="SEARCH">
          <button type="button" class="close" data-dismiss="modal" aria-label="Close">
            <i class="tim-icons icon-simple-remove"></i>
          </button>
        </div>

        <div class="modal-footer">
        </div>
      </div>
    </div>
  </div> -->
              <li class="dropdown nav-item">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                  <div class="notification d-none d-lg-block d-xl-block"></div>
                  <i class="tim-icons icon-sound-wave"></i>
                  <p class="d-lg-none">
                    New Notifications
                  </p>
                </a>
                <ul class="dropdown-menu dropdown-menu-right dropdown-navbar">
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Mike John responded to your email</a>
                  </li>
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">You have 5 more tasks</a>
                  </li>
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Your friend Michael is in town</a>
                  </li>
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Another notification</a>
                  </li>
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Another one</a>
                  </li>
                </ul>
              </li>
              <li class="dropdown nav-item">
                <a href="#" class="dropdown-toggle nav-link" data-toggle="dropdown">
                  <div class="photo">
                    <img src="../../resources/img/anime3.png">
                  </div>
                  <b class="caret d-none d-lg-block d-xl-block"></b>
                  <p class="d-lg-none">
                    Log out
                  </p>
                </a>
                <ul class="dropdown-menu dropdown-navbar">
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Profile</a>
                  </li>
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Settings</a>
                  </li>
                  <div class="dropdown-divider"></div>
                  <li class="nav-link">
                    <a href="#" class="nav-item dropdown-item">Log out</a>
                  </li>
                </ul>
              </li>
              <li class="separator d-lg-none"></li>
            </ul>
          </div>
        </div>
      </nav>
      <div class="modal fade" id="searchModal" tabindex="-1" role="dialog" aria-labelledby="searchModal" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content">
            <div class="modal-header">
              <input type="text" class="form-control" id="inlineFormInputGroup" placeholder="SEARCH">
              <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                <i class="tim-icons icon-simple-remove"></i>
              </button>
            </div>
            <div class="modal-footer">
            </div>
          </div>
        </div>
      </div>
      <!-- End Navbar -->
      
		
      <div class="content">
      	 
           <div class="row">
          <div class="col-md-12">
            <div class="card ">
              <div class="card-header">
                <h3 class="title">차량 권한 등록</h3>
              </div>
              
              <div class="col-md-12">
                <div class="places-buttons">
                  <div class="row col-md-12">
                    <div class="col-md-6 ml-auto mr-auto text-center">
                      <h4 class="card-title">
                       	세대정보 검색
                        <p class="category">조회 조건을 선택하세요.</p>
                      </h4>
                    </div>
                  </div>
                  <div class="row ">
                    <div class="col-lg-12 ml-auto mr-auto">
                      <div class="row">
                        <div class="col-md-4">
                          <button type="button" class="btn btn-primary btn-block vehicleAdd" data-toggle="modal" data-target="#addVehicleModal" data-whatever="차량 등록">차량 등록</button>
                        </div>
                        <div class="col-md-4">
                         <button type="button" class="btn btn-primary btn-block vehicleModify" data-toggle="modal" data-target="#modifyVehicleModal" data-whatever="차량 수정">차량 수정</button>
                        </div>
                         <div class="col-md-4">
                         <button type="button" class="btn btn-primary btn-block vehicleDelete" data-toggle="modal" data-target="#deleteVehicleModal" data-whatever="차량 삭제" >차량 삭제</button>
                        </div>
                         <div class="col-md-4">
                         <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#vehicleNumberModal" data-whatever="차량번호로 검색">차량번호로 검색</button>
                        </div>
                        <div class="col-md-4">
                          <button type="button" class="btn btn-primary btn-block" data-toggle="modal" data-target="#geneIdxModal"  data-whatever="세대정보로 검색">세대정보로 검색</button>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
          </div>
              
              <div class="card-body">
                <div class="table-responsive">
                  <table class="table tablesorter " id="">
                    <thead class=" text-primary">
                    
                      <th>
                        <div class="form-check checkAll" id="checkAll">
                            <label class="form-check-label">
                              <input class="form-check-input allvehicle" type="checkbox" value="">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                      </th>
                       <th>
                        관리번호
                      </th>
                      <th>
                        세대정보
                      </th>
                      <th>
                        등록 여부
                      </th>
                      <th class="text-center">
                        등록 차량 대수
                      </th>
                    </thead>
                    <tbody>
                      <tr>
                      	<td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value="" name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                        <td id="vehicle-idx">C100000</td>
                        <td id="gene-idx">103동 906호</td>
                        <td>등록</td>
                        <td class="text-center">2대</td>
                      </tr>
                      <tr>
                     	 <td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value="" name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                        <td>
                          C100001
                        </td>
                        <td>
                          103동 905호
                        </td>
                        <td>
                          미등록
                        </td>
                        <td class="text-center">
                          -
                        </td>
                      </tr>
                      <tr>
                      	<td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value="" name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                         <td>
                          C100002
                        </td>
                        <td>
                          103동 904호
                        </td>
                        <td>
                          등록
                        </td>
                        <td class="text-center">
                          1대
                        </td>
                      </tr>
                      <tr>
                      	<td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value=""name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                         <td>
                          C100003
                        </td>
                        <td>
                          103동 905호
                        </td>
                        <td>
                          등록
                        </td>
                        <td class="text-center">
                          1대
                        </td>
                      </tr>
                      <tr>
                      	<td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value="" name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                         <td>
                          C100004
                        </td>
                        <td>
                          103동 903호
                        </td>
                        <td>
                          등록
                        </td>
                        <td class="text-center">
                          1대
                        </td>
                      </tr>
                      <tr>
                      	<td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value="" name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                         <td>
                          C100005
                        </td>
                        <td>
                          103동 902호
                        </td>
                        <td>
                          미등록
                        </td>
                        <td class="text-center">
                          -
                        </td>
                      </tr>
                      <tr>
                      	<td>
                          <div class="form-check">
                            <label class="form-check-label">
                              <input class="form-check-input vehicle" type="checkbox" value="" name="vehicle">
                              <span class="form-check-sign">
                                <span class="check"></span>
                              </span>
                            </label>
                          </div>
                        </td>
                         <td>
                          C100006
                        </td>
                        <td>
                          103동 901호
                        </td>
                        <td>
                          미등록
                        </td>
                        <td class="text-center">
                          -
                        </td>
                      </tr>
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>
          <div class="row mt-5 d-flex card-body ">
	          <div class="col text-center">
	            <div class="block-27">
	              <ul>
	                <li><a href="#">&lt;</a></li>
	                <li class="active"><span>1</span></li>
	                <li><a href="#">2</a></li>
	                <li><a href="#">3</a></li>
	                <li><a href="#">4</a></li>
	                <li><a href="#">5</a></li>
	                <li><a href="#">&gt;</a></li>
	              </ul>
	            </div>
	          </div>
	        </div>
    	</div>
    	</div>
        </div>
      </div>
      
   
      
      <footer class="footer">
        <div class="container-fluid">
          <nav>
            <ul>
              <li>
                <a href="https://www.creative-tim.com">
                  Creative Tim
                </a>
              </li>
              <li>
                <a href="http://presentation.creative-tim.com">
                  About Us
                </a>
              </li>
              <li>
                <a href="http://blog.creative-tim.com">
                  Blog
                </a>
              </li>
            </ul>
          </nav>
          <div class="copyright float-right">
            ©
            <script>
              document.write(new Date().getFullYear())
            </script> made with <i class="tim-icons icon-heart-2"></i> by
            <a href="https://www.creative-tim.com" target="_blank">Creative Tim</a> for a better web.
          </div>
      </footer>
      </div>
    </div>
    <div class="fixed-plugin">
      <div class="dropdown show-dropdown">
        <a href="#" data-toggle="dropdown">
          <i class="fa fa-cog fa-2x"> </i>
        </a>
        <ul class="dropdown-menu">
          <li class="header-title"> Sidebar Background</li>
          <li class="adjustments-line">
            <a href="javascript:void(0)" class="switch-trigger background-color">
              <div class="badge-colors text-center">
                <span class="badge filter badge-primary active" data-color="primary"></span>
                <span class="badge filter badge-blue" data-color="blue"></span>
                <span class="badge filter badge-green" data-color="green"></span>
              </div>
              <div class="clearfix"></div>
            </a>
          </li>
          <li class="adjustments-line text-center color-change">
            <span class="color-label">LIGHT MODE</span>
            <span class="badge light-badge mr-2"></span>
            <span class="badge dark-badge ml-2"></span>
            <span class="color-label">DARK MODE</span>
          </li>
          <li class="button-container">
            <a href="https://www.creative-tim.com/product/black-dashboard" target="_blank" class="btn btn-primary btn-block btn-round">Download Now</a>
            <a href="https://demos.creative-tim.com/black-dashboard/docs/1.0/getting-started/introduction.html" target="_blank" class="btn btn-default btn-block btn-round">
              Documentation
            </a>
          </li>
          <li class="header-title">Thank you for 95 shares!</li>
          <li class="button-container text-center">
            <button id="twitter" class="btn btn-round btn-info"><i class="fab fa-twitter"></i> &middot; 45</button>
            <button id="facebook" class="btn btn-round btn-info"><i class="fab fa-facebook-f"></i> &middot; 50</button>
            <br>
            <br>
            <a class="github-button" href="https://github.com/creativetimofficial/black-dashboard" data-icon="octicon-star" data-size="large" data-show-count="true" aria-label="Star ntkme/github-buttons on GitHub">Star</a>
          </li>
        </ul>
      </div>
    </div>
    
    <!-- 모달 구현 -->
    <!-- 차량등록 모달 -->
    
    <div class="modal fade" id="addVehicleModal" tabindex="-1" role="dialog" aria-labelledby="addVehicleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="background-image: linear-gradient(to bottom left, #344675, #263148, #344675); color:white;">
	      <div class="modal-header">
	       	<h4 class="modal-title" id="addVehicleModalLabel">차량 등록</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">세대 정보(동)</label>
	            <input type="text" class="form-control" id="add-generation-bulding">
	          </div>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">세대 정보(호수)</label>
	            <input type="text" class="form-control" id="add-generation-number">
	          </div>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">차량 번호</label>
	            <input type="text" class="form-control" id="add-vehicle-number">
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소하기</button>
	        <button type="button" class="btn btn-primary btn-add-vehicle" data-dismiss="modal">등록하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 차량 수정 모달 -->
	<div class="modal fade" id="modifyVehicleModal" tabindex="-1" role="dialog" aria-labelledby="modifyVehicleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="background-image: linear-gradient(to bottom left, #344675, #263148, #344675); color:white;">
	      <div class="modal-header">
	       	<h4 class="modal-title" id="modifyVehicleModalLabel">차량 수정</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">세대 정보(동)</label>
	            <input type="text" class="form-control" id="modify-generation-bulding">
	          </div>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">세대 정보(호수)</label>
	            <input type="text" class="form-control" id="modify-generation-number">
	          </div>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">차량 번호</label>
	            <input type="text" class="form-control" id="modify-vehicle-number">
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소하기</button>
	        <button type="button" class="btn btn-primary btn-modify-vehicle" data-dismiss="modal">수정하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	<!-- 차량 삭제 모달 -->
	<div class="modal fade" id="deleteVehicleModal" tabindex="-1" role="dialog" aria-labelledby="deleteVehicleModalLabel" aria-hidden="true">
	  <div class="modal-dialog">
	    <div class="modal-content" style="background-image: linear-gradient(to bottom left, #344675, #263148, #344675); color:white;">
	      <div class="modal-header">
	       	<h4 class="modal-title" id="deleteVehicleModalLabel">차량 삭제</h4>
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	      </div>
	      <div class="modal-body">
	        <form>
	          <div class="form-group">
	            <label for="recipient-name" class="control-label">총 <span id="result"></span> 건을 정말 삭제하시겠습니까?</label>
	          </div>
	        </form>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">취소하기</button>
	        <button type="button" class="btn btn-primary btn-delete-vehicle" data-dismiss="modal">삭제하기</button>
	      </div>
	    </div>
	  </div>
	</div>
	
	
	<div class="modal fade" id="vehicleNumberModal" tabindex="-1" role="dialog" aria-labelledby="vehicleNumberModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content" style="background-image: linear-gradient(to bottom left, #344675, #263148, #344675); color:white;">
            <div class="modal-header">
            	<h4 class="modal-title" id="vehicleNumberModalLabel">차량번호로 검색</h4>
             	 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                <i class="tim-icons icon-simple-remove"></i>
	              </button>
            </div>
            <div class="modal-body">
	        <form>
	          <div class="form-group">
	           <input type="text" class="form-control vehicle-keyword" id="inlineFormInputGroup" placeholder="차량번호로 검색">
	          </div>
	        </form>
	      </div>
	      
            <div class="modal-footer">
            <button type="button" class="btn btn-primary btn-search-vehicleNumber" data-dismiss="modal">검색</button>
            </div>
          </div>
        </div>
      </div>
      
      
      <div class="modal fade" id="geneIdxModal" tabindex="-1" role="dialog" aria-labelledby="geneIdxModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
          <div class="modal-content" style="background-image: linear-gradient(to bottom left, #344675, #263148, #344675); color:white;">
            <div class="modal-header">
            	<h4 class="modal-title" id="geneIdxModalLabel">세대정보로 검색</h4>
             	 <button type="button" class="close" data-dismiss="modal" aria-label="Close">
	                <i class="tim-icons icon-simple-remove"></i>
	              </button>
            </div>
            <div class="modal-body">
	        <form>
	          <div class="form-group">
	           <input type="text" class="form-control generation-ketword" id="inlineFormInputGroup" placeholder="세대정보로 검색 (103-906)">
	          </div>
	        </form>
	      </div>
	      
            <div class="modal-footer">
            <button type="button" class="btn btn-primary btn-search-generationIdx" data-dismiss="modal">검색</button>
            </div>
          </div>
        </div>
      </div>
      
      
    
    <!--   Core JS Files   -->
    <script src="../../../resources/js/admin/vehicle.js"></script>
    <script src="../../../resources/js/admin/core/jquery.min.js"></script>
    <script src="../../../resources/js/admin/core/popper.min.js"></script>
    <script src="../../../resources/js/admin/core/bootstrap.min.js"></script>
    <script src="../../../resources/js/admin/plugins/perfect-scrollbar.jquery.min.js"></script>
    <!--  Google Maps Plugin    -->
    <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_KEY_HERE"></script>
    <!-- Chart JS -->
    <script src="../../../resources/js/admin/plugins/chartjs.min.js"></script>
    <!--  Notifications Plugin    -->
    <script src="../../../resources/js/admin/plugins/bootstrap-notify.js"></script>
    <!-- Control Center for Black Dashboard: parallax effects, scripts for the example pages etc -->
    <script src="../../../resources/js/admin/black-dashboard.min.js?v=1.0.0" type="text/javascript"></script>
    <!-- Black Dashboard DEMO methods, don't include it in your project! -->
    <script src="../../../resources/demo/demo.js"></script>
    
    <script>
      $(document).ready(function() {
        $().ready(function() {
          $sidebar = $('.sidebar');
          $navbar = $('.navbar');

          $full_page = $('.full-page');

          $sidebar_responsive = $('body > .navbar-collapse');
          sidebar_mini_active = true;
          white_color = false;

          window_width = $(window).width();

          fixed_plugin_open = $('.sidebar .sidebar-wrapper .nav li.active a p').html();



          $('.fixed-plugin a').click(function(event) {
            // Alex if we click on switch, stop propagation of the event, so the dropdown will not be hide, otherwise we set the  section active
            if ($(this).hasClass('switch-trigger')) {
              if (event.stopPropagation) {
                event.stopPropagation();
              } else if (window.event) {
                window.event.cancelBubble = true;
              }
            }
          });

          $('.fixed-plugin .background-color span').click(function() {
            $(this).siblings().removeClass('active');
            $(this).addClass('active');

            var new_color = $(this).data('color');

            if ($sidebar.length != 0) {
              $sidebar.attr('data-color', new_color);
            }

            if ($navbar.length != 0) {
              $navbar.attr('data-color', new_color);
            }

            if ($full_page.length != 0) {
              $full_page.attr('filter-color', new_color);
            }

            if ($sidebar_responsive.length != 0) {
              $sidebar_responsive.attr('data-color', new_color);
            }
          });

          $('.switch-sidebar-mini input').on("switchChange.bootstrapSwitch", function() {
            var $btn = $(this);

            if (sidebar_mini_active == true) {
              $('body').removeClass('sidebar-mini');
              sidebar_mini_active = false;
              blackDashboard.showSidebarMessage('Sidebar mini deactivated...');
            } else {
              $('body').addClass('sidebar-mini');
              sidebar_mini_active = true;
              blackDashboard.showSidebarMessage('Sidebar mini activated...');
            }

            // we simulate the window Resize so the charts will get updated in realtime.
            var simulateWindowResize = setInterval(function() {
              window.dispatchEvent(new Event('resize'));
            }, 180);

            // we stop the simulation of Window Resize after the animations are completed
            setTimeout(function() {
              clearInterval(simulateWindowResize);
            }, 1000);
          });

          $('.switch-change-color input').on("switchChange.bootstrapSwitch", function() {
            var $btn = $(this);

            if (white_color == true) {

              $('body').addClass('change-background');
              setTimeout(function() {
                $('body').removeClass('change-background');
                $('body').removeClass('white-content');
              }, 900);
              white_color = false;
            } else {

              $('body').addClass('change-background');
              setTimeout(function() {
                $('body').removeClass('change-background');
                $('body').addClass('white-content');
              }, 900);

              white_color = true;
            }


          });

          $('.light-badge').click(function() {
            $('body').addClass('white-content');
          });

          $('.dark-badge').click(function() {
            $('body').removeClass('white-content');
          });
        });
      });
        
      $('.modal').on('hidden.bs.modal', function (e) {
    	    $(this).find('form')[0].reset()
    	});
    </script>
    <script>
      $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js
        demo.initDashboardPageCharts();

      });
    </script>
</body>
</html>