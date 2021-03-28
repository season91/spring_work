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
            <div class="card">
              <div class="card-header">
                <h3 class="title">관리비 수정</h3>
                <p>수정시 기존 정보가 전부 변경됩니다. 수정시 유의바랍니다. 이미 부과된 연체료는 원복이 어려우니 세대감면액을 이용해주시기 바랍니다.</p>
              </div>
                	  
              <div class="card-body">
                  <c:choose>
                  	<c:when test="${mgmtfee eq null }">
                  		<div class="col-md-2 pr-md-1">
	                      <div class="form-group">
	                        <label>조회내역이 없습니다.</label>
	                      </div>
	                    </div>                 	
                  	</c:when>
                  	<c:otherwise>
                  	 <form id="form-mgmtfee-modify" action="${context}/admin/mgmtfeemodifyimpl" method="post">
                  	<div class="row">
	                    <div class="col-md-3 pr-md-1">
	                      <div class="form-group">
	                        <label>아파트정보</label>
	                        <input type="text" class="form-control" readonly="readonly" name="apartmentIdx" value="${mgmtfee.apartmentIdx }">
	                      </div>
	                    </div>
	                    <div class="col-md-3 pl-md-1">
	                      <div class="form-group">
	                        <label for="exampleInputEmail1">세대정보</label>
	                        <input type="tel" class="form-control" placeholder="동호수" value="${generation.building}동 ${generation.num}호">
	                      </div>
	                    </div>
	                  </div>
	                 <div class="row">
                	 <div class="col-md-2 px-md-1">
                      <div class="form-group">
                        <label>관리비 번호</label>
                        <input type="text" class="form-control" placeholder="Company" name="mgmtfeeIdx" value="${mgmtfee.mgmtfeeIdx }">
                      </div>
                    </div>
                   
                    <div class="col-md-2 px-md-1">
                      <div class="form-group">
                        <label>세대 관리 번호</label>
                        <input type="text" class="form-control" placeholder="Company" name="generationIdx" value="${mgmtfee.generationIdx }">
                      </div>
                    </div>
                  	<div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>일반관리비</label>
                        <input type="text" class="form-control" placeholder="Company" name="gnrlMgmtFee" value="${mgmtfee.gnrlMgmtFee }">
                      </div>
                    </div>                 	
                     <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>청소비</label>
                        <input type="text" class="form-control" placeholder="Company" name="cleanFee" value="${mgmtfee.cleanFee }">
                      </div>
                    </div>                 	
                     <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>승강기 유지비</label>
                        <input type="text" class="form-control" placeholder="Company" name="elvtrMnfee" value="${mgmtfee.elvtrMnfee }">
                      </div>
                    </div>                 	
                     <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>세대전기료</label>
                        <input type="text" class="form-control" placeholder="Company" name="genElctr" value="${mgmtfee.genElctr }">
                      </div>
                    </div>                 	
                     <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>공동전기료</label>
                        <input type="text" class="form-control" placeholder="Company" name="comonElctr" value="${mgmtfee.comonElctr }">
                      </div>
                    </div>                 	
                     <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>세대수도료</label>
                        <input type="text" class="form-control" placeholder="Company" name="genWater" value="${mgmtfee.genWater }">
                      </div>
                    </div>                 	
                     <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>하수도료</label>
                        <input type="text" class="form-control" placeholder="Company" name="sewer" value="${mgmtfee.sewer }">
                      </div>
                    </div>    
                    <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>경비비</label>
                        <input type="text" class="form-control" placeholder="Company" name="expenses" value="${mgmtfee.expenses }">
                      </div>
                    </div>     
                    <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>세대감면액</label>
                        <input type="text" class="form-control" placeholder="Company" name="genReduction" value="${mgmtfee.genReduction }">
                      </div>
                    </div>
                    <c:choose>
                    	<c:when test="${overdue eq null }">
                    		<div class="col-md-2 pr-md-1">
		                      <div class="form-group">
		                        <label>연체료</label>
		                        <input type="text" class="form-control"  readonly="readonly"  name="overdueFee" value="0">
		                      </div>
		                    </div>
                   		</c:when>
                   		<c:otherwise>
                   			<div class="col-md-2 pr-md-1">
		                      <div class="form-group">
		                        <label>연체료</label>
		                        <input type="text" class="form-control" placeholder="Company" name="overdueFee" value="${overdue.overdueFee }">
		                      </div>
		                    </div>
                   		</c:otherwise>
                    </c:choose>
                   
                    <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>납기일</label>
                        <input type="text" class="form-control" placeholder="Company" name="dueDate" value="${mgmtfee.dueDate }">
                      </div>
                    </div>     
                    <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>관리 시작일</label>
                        <input type="text" class="form-control" placeholder="Company" name="mgmtStartDate" value="${mgmtfee.mgmtStartDate }">
                      </div>
                    </div>     
                    <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>관리 종료일</label>
                        <input type="text" class="form-control" placeholder="Company" name="mgmtEndDate" value="${mgmtfee.mgmtEndDate }">
                      </div>
                    </div>     
                    <div class="col-md-2 pr-md-1">
                      <div class="form-group">
                        <label>관리비 작성일</label>
                        <input type="text" class="form-control" placeholder="Company" name="mgmtWriteDate" value="${mgmtfee.mgmtWriteDate }">
                      </div>
                    </div>
                    <c:choose>
                    	<c:when test="${mgmtfee.isPayment eq 0 }">
                   		  <div class="col-md-2 pr-md-1">
		                      <div class="form-group">
		                        <label>결제여부</label>
		                        <input type="text" class="form-control" placeholder="Company" name="isPaymentText" value="미납">
		                      </div>
		                    </div>
                    	</c:when>
                    	<c:otherwise>
                    	  <div class="col-md-2 pr-md-1">
		                      <div class="form-group">
		                        <label>결제여부</label>
		                        <input type="text" class="form-control" placeholder="Company" name="isPaymentText" value="완료">
		                      </div>
		                    </div>
                    	</c:otherwise>
                    </c:choose>     
                   </div>
                   <div class="row">
                    <div class="col-md-8">
                      <div class="form-group">
                        <label>알림 메시지</label>
                        <textarea rows="4" cols="80" class="form-control" name="mgmtfee-alarm">지난달 세대전기료가 과다 부과되어 당월 금액 조정하였습니다.</textarea>
                      </div>
                    </div>
                  </div>
                    <div class="card-footer" style="display: flex; justify-content: space-around;">
	                <button type="submit" class="btn btn-fill btn-primary">전송하기</button>
	                <a href="${context }/admin/mgmtfee"><button type="button" class="btn btn-fill btn-success">목록으로</button></a>
	                <a href="${context }/admin/mgmtfeedelete?mgmtfeeidx=${mgmtfee.mgmtfeeIdx}"><button type="button" class="btn btn-fill btn-warning">삭제하기</button></a>
                	</div>
                </form>
                	
                </c:otherwise>
              </c:choose>
             	
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
    <!--   Core JS Files   -->
    <script src="../../../resources/js/admin/mgmtfeeupload.js"></script>
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
    </script>
    <script>
      $(document).ready(function() {
        // Javascript method's body can be found in assets/js/demos.js
        demo.initDashboardPageCharts();

      });
    </script>
</body>
</html>