<%-- 
    Document   : homepage
    Created on : May 29, 2019, 8:39:59 PM
    Author     : Phuc Nguyen -VN
--%>

<!DOCTYPE html>
<html lang="en">

    <head>

        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="">
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <title>SAFO-Sale Food</title>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

        <style>
            input[type=range] {
                -webkit-appearance: none;
                width: 100%;
                margin: 6.25px 0;
            }
            input[type=range]:focus {
                outline: none;
            }
            input[type=range]::-webkit-slider-runnable-track {
                width: 100%;
                height: 26.5px;
                cursor: pointer;
                box-shadow: 1px 1px 1px #000000, 0px 0px 1px #0d0d0d;
                background: #53bedb;
                border-radius: 1.3px;
                border: 0.2px solid #010101;
            }
            input[type=range]::-webkit-slider-thumb {
                box-shadow: 1.8px 1.8px 1px #6174a0, 0px 0px 1.8px #7182aa;
                border: 0.6px solid #000000;
                height: 39px;
                width: 15px;
                border-radius: 12px;
                background: #ffffff;
                cursor: pointer;
                -webkit-appearance: none;
                margin-top: -6.45px;
            }
            input[type=range]:focus::-webkit-slider-runnable-track {
                background: #60c3de;
            }
            input[type=range]::-moz-range-track {
                width: 100%;
                height: 26.5px;
                cursor: pointer;
                box-shadow: 1px 1px 1px #000000, 0px 0px 1px #0d0d0d;
                background: #53bedb;
                border-radius: 1.3px;
                border: 0.2px solid #010101;
            }
            input[type=range]::-moz-range-thumb {
                box-shadow: 1.8px 1.8px 1px #6174a0, 0px 0px 1.8px #7182aa;
                border: 0.6px solid #000000;
                height: 39px;
                width: 15px;
                border-radius: 12px;
                background: #ffffff;
                cursor: pointer;
            }
            input[type=range]::-ms-track {
                width: 100%;
                height: 26.5px;
                cursor: pointer;
                background: transparent;
                border-color: transparent;
                color: transparent;
            }
            input[type=range]::-ms-fill-lower {
                background: #46b9d8;
                border: 0.2px solid #010101;
                border-radius: 2.6px;
                box-shadow: 1px 1px 1px #000000, 0px 0px 1px #0d0d0d;
            }
            input[type=range]::-ms-fill-upper {
                background: #53bedb;
                border: 0.2px solid #010101;
                border-radius: 2.6px;
                box-shadow: 1px 1px 1px #000000, 0px 0px 1px #0d0d0d;
            }
            input[type=range]::-ms-thumb {
                box-shadow: 1.8px 1.8px 1px #6174a0, 0px 0px 1.8px #7182aa;
                border: 0.6px solid #000000;
                height: 39px;
                width: 15px;
                border-radius: 12px;
                background: #ffffff;
                cursor: pointer;
                height: 26.5px;
            }
            input[type=range]:focus::-ms-fill-lower {
                background: #53bedb;
            }
            input[type=range]:focus::-ms-fill-upper {
                background: #60c3de;
            }
            input[type=text], input[type=number],input[type=date]{
                border-top: none;border-left: none;border-right: none;
            }
        </style>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script>
            $('document').ready(function () {
                $table = $('#dataTable').dataTable({
                    "ajax": {
                        "url": "api/product/getAllStoreProduct?id=${sessionScope.store.storeId}",
                        "method": "GET", "dataType": "json"
                    },
                    "processing": true,
                    "serverSide": false,
                    "columns": [
                        {data: function (row, type, set) {
                                if (type === 'display') {
                                    return "<img src='" + row.image + "' width=70px;height=30px />";
                                }
                                return "";
                            }},
                        {data: "name"},
                        {data: "discPrice"},
                        {data: "totalQuantity"},
                        {data: "soldNum"},
                        {data: "inStock"},
                        {data: "expireDate"},
                        {data: function (row, type, set) {
                                if (type === 'display') {
                                    if (row.status === null)
                                        return "Nothing";
                                }
                                return "Status: " + type;
                            }
                        }
                    ]
//                                                    , "destroy": true
                });
            });
        </script>
    </head>

    <body id="page-top">

        <!-- Page Wrapper -->
        <div id="wrapper">

            <!-- Sidebar -->
            <ul class="navbar-nav bg-gradient-primary sidebar sidebar-dark accordion" id="accordionSidebar">

                <!-- Sidebar - Brand -->
                <a class="sidebar-brand d-flex align-items-center justify-content-center" href="homepage">
                    <div class="sidebar-brand-icon rotate-n-15">
                        <i class="fas fa-laugh-wink"></i>
                    </div>
                    <div class="sidebar-brand-text mx-3">SAFO</div>
                </a>

                <!-- Divider -->
                <hr class="sidebar-divider my-0">

                <!-- Nav Item - Home -->
                <li class="nav-item active">
                    <a class="nav-link" href="homepage">
                        <i class="fas fa-fw fa-tachometer-alt"></i>
                        <span>Home</span></a>
                </li>
                
                <!-- Divider -->
                <hr class="sidebar-divider">

                <!-- Heading -->
                <div class="sidebar-heading">
                    Utility
                </div>
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="addStoreProduct" />
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Add store product</span>
                    </a>
                </li>
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="storeProduct" />
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Store Product</span>
                    </a>
                </li>
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed"  href="order" />
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Order</span>
                    </a>
                </li>

                <!-- Divider -->
                <hr class="sidebar-divider d-none d-md-block">

                <!-- Sidebar Toggler (Sidebar) -->
                <div class="text-center d-none d-md-inline">
                    <button class="rounded-circle border-0" id="sidebarToggle"></button>
                </div>

            </ul>
            <!-- End of Sidebar -->

            <!-- Content Wrapper -->
            <div id="content-wrapper" class="d-flex flex-column">

                <!-- Main Content -->
                <div id="content">

                    <!-- Topbar -->
                    <nav class="navbar navbar-expand navbar-light bg-white topbar mb-4 static-top shadow">

                        <!-- Sidebar Toggle (Topbar) -->
                        <button id="sidebarToggleTop" class="btn btn-link d-md-none rounded-circle mr-3">
                            <i class="fa fa-bars"></i>
                        </button>

                        <!-- Topbar Search -->
                        <form class="d-none d-sm-inline-block form-inline mr-auto ml-md-3 my-2 my-md-0 mw-100 navbar-search" id="searchOrder">
                            <div class="input-group">
                                <input type="text" class="form-control bg-light border-0 small" placeholder="Check code..." aria-label="Search" aria-describedby="basic-addon2">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="submit">
                                        <i class="fas fa-search fa-sm"></i>
                                    </button>
                                </div>
                            </div>
                        </form>

                        <!-- Topbar Navbar -->
                        <ul class="navbar-nav ml-auto">

                            <!-- Nav Item - Search Dropdown (Visible Only XS) -->
                            <li class="nav-item dropdown no-arrow d-sm-none">
                                <a class="nav-link dropdown-toggle" href="#" id="searchDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-search fa-fw"></i>
                                </a>
                                <!-- Dropdown - Messages -->
                                <div class="dropdown-menu dropdown-menu-right p-3 shadow animated--grow-in" aria-labelledby="searchDropdown">
                                    <form class="form-inline mr-auto w-100 navbar-search">
                                        <div class="input-group">
                                            <input type="text" class="form-control bg-light border-0 small" placeholder="Check code..." aria-label="Search" aria-describedby="basic-addon2">
                                            <div class="input-group-append">
                                                <button class="btn btn-primary" type="button">
                                                    <i class="fas fa-search fa-sm"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </li>

                            <!-- Nav Item - Alerts -->
                            <li class="nav-item dropdown no-arrow mx-1">
                                <a class="nav-link dropdown-toggle" href="#" id="alertsDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <i class="fas fa-bell fa-fw"></i>
                                    <!-- Counter - Alerts -->
                                    <span class="badge badge-danger badge-counter">2+</span>
                                </a>
                                <!-- Dropdown - Alerts -->
                                <div class="dropdown-list dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="alertsDropdown">
                                    <h6 class="dropdown-header">
                                        Product Notification
                                    </h6>
                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-primary">
                                                <i class="fas fa-file-alt text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">June 1, 2019</div>
                                            <span class="font-weight-bold">Product <b>Coca Cola #1234</b>  is sold out</span>
                                        </div>
                                    </a>

                                    <a class="dropdown-item d-flex align-items-center" href="#">
                                        <div class="mr-3">
                                            <div class="icon-circle bg-warning">
                                                <i class="fas fa-exclamation-triangle text-white"></i>
                                            </div>
                                        </div>
                                        <div>
                                            <div class="small text-gray-500">May 30, 2019</div>
                                            Product <b>Strawberry (100 gram) #1235</b> has expired
                                        </div>
                                    </a>
                                    <a class="dropdown-item text-center small text-gray-500" href="#">Show All Alerts</a>
                                </div>
                            </li>
                            <div class="topbar-divider d-none d-sm-block"></div>

                            <!-- Nav Item - User Information -->
                            <li class="nav-item dropdown no-arrow">
                                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">Valerie Luna</span>
                                    <img class="img-profile rounded-circle" src="https://source.unsplash.com/QAB-WJcbgJk/60x60">
                                </a>
                                <!-- Dropdown - User Information -->
                                <div class="dropdown-menu dropdown-menu-right shadow animated--grow-in" aria-labelledby="userDropdown">
                                    <a class="dropdown-item" href="#">
                                        <i class="fas fa-user fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Profile
                                    </a>
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="#" data-toggle="modal" data-target="#logoutModal">
                                        <i class="fas fa-sign-out-alt fa-sm fa-fw mr-2 text-gray-400"></i>
                                        Logout
                                    </a>
                                </div>
                            </li>

                        </ul>

                    </nav>
                    <!-- End of Topbar -->
                    <!-- Begin Page Content -->
                    <div class="container-fluid">

                        <!-- Page Heading -->
                        <h1 class="h3 mb-2 text-gray-800"><c:out value="${sessionScope.store.storeName}"/></h1>
                        <p class="mb-4"><c:out value="Retail store at ${sessionScope.store.locationId.address}"/><br><c:out value="Open from ${sessionScope.store.openHour} - ${sessionScope.store.closeHour}"/></p>


                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h4 class="m-0 font-weight-bold text-primary" style="float:left">Sell product </h4>
                                <!--<input type="button" value="Post Sale" data-toggle="modal" data-target="#addProductModal" style="float:right" class="btn btn-link rounded-circle mr-3"/>-->
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Image</th>
                                                <th>Name</th>
                                                <th>Disc. Price Per Unit</th>
                                                <th>Total</th>
                                                <th>No. Sold</th>
                                                <th>In Stock</th>
                                                <th>Expired Date</th>
                                                <th>Status</th>
                                                <!--<th>Last Update</th>-->
                                                <!--<th>Action</th>-->

                                            </tr>
                                        </thead>
                                        <tbody></tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Image</th>
                                                <th>Name</th>
                                                <th>Disc. Price Per Unit</th>
                                                <th>Total</th>
                                                <th>No. Sold</th>
                                                <th>In Stock</th>
                                                <th>Expired Date</th>
                                                <th>Status</th>
                                                <!--<th>Last Update</th>-->
                                                <!--<th>Action</th>-->
                                            </tr>
                                        </tfoot>
                                    </table>
                                </div>
                            </div>
                        </div>

                    </div>
                    <!-- /.container-fluid -->


                </div>
                <!-- End of Main Content -->

                <!-- Footer -->
                <footer class="sticky-footer bg-white">
                    <div class="container my-auto">
                        <div class="copyright text-center my-auto">
                            <span>Copyright &copy; Your Website 2019</span>
                        </div>
                    </div>
                </footer>
                <!-- End of Footer -->

            </div>
            <!-- End of Content Wrapper -->

        </div>
        <!-- End of Page Wrapper -->

        <!-- Scroll to Top Button-->
        <a class="scroll-to-top rounded" href="#page-top">
            <i class="fas fa-angle-up"></i>
        </a>

        <!-- Logout Modal-->
        <div class="modal fade" id="logoutModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Ready to Leave?</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="login.html">Logout</a>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="informationModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Order Information</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body" style="text-align: center;align-items: center">
                        <form>
                            <table border="0" cellspacing="1" cellpadding="1" style="margin: 0 auto;width: 100%" id="infoTable">
                                <tbody>
                                    <tr>
                                        <td colspan="3" style="text-align: center"><h3 class=""><b>Bách Hóa Xanh</b></h3></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" style="text-align: center"><p>34 Trung My Tay, 12 district, Ho Chi Minh city</p></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">----------***----------</td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" style="text-align: center"><h3 class=""><b>ORDER INFORMATION</b></h3></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" style="text-align: center"><hr></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left"><b>Customer:</b></td>
                                        <td style="text-align: right" colspan="2">#0001_Truong Hai Nguyen</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left"><b>OrderId:</b></td>
                                        <td style="text-align: right" colspan="2">#1234</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left"><b>Receive Time:</b></td>
                                        <td style="text-align: right" colspan="2"><span>6/6/2019 13:00:01</span></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3" style="text-align: center"><hr></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left;width: 55%" ><b>Product</b></td>
                                        <td style="text-align: center;width: 10%"><b>Amount</b></td>
                                        <td style="text-align: right;width: 35%"><b>Cash &nbsp;</b></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left">COCA COLA</td>
                                        <td style="text-align: center">1</td>
                                        <td style="text-align: right">3,500 &nbsp;</td>
                                    </tr>
                                    <tr>

                                        <td style="text-align: left">3,500<br> </td>
                                        <td style="text-align: center"></td>
                                        <td style="text-align: right"></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left">Hao Hao spicy & shrimp instant noodle </td>
                                        <td style="text-align: center">5</td>
                                        <td style="text-align: right">12,500 &nbsp;</td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left">2,500 &nbsp;</td>
                                        <td style="text-align: center"></td>
                                        <td style="text-align: right"></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><hr></td>
                                    </tr>
                                    <tr>
                                        <td style="text-align: left"><b>Total </b></td>
                                        <td style="text-align: center"></td>
                                        <td style="text-align: right"><b>16,000 &nbsp;</b></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3"><hr></td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">THANK YOU FOR SHOPPING</td>
                                    </tr>
                                    <tr>
                                        <td colspan="3">See You Again</td>
                                    </tr>
                                </tbody>
                            </table>
                        </form>
                    </div>                    
                </div>
            </div>
        </div>
        <!-- Post Sale Modal Modal-->
        <div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Post Sale</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">×</span>
                        </button>
                    </div>
                    <div class="modal-body">
                        <form id="addProduct">
                            <table border="0">
                                <tbody>
                                    <tr>
                                        <td>Name</td>
                                        <td> <input type="text" name="txtName" value="" placeholder="Product name" required  style="width: 100%;border-top: none;border-left: none;border-right: none;"/> </td>
                                    </tr>
                                    <tr>
                                        <td >Image </td>
                                        <td > <input type="file" name="txtFile" value="" onchange="uploadImg(event)"  /> </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2">
                                            <img width="400px" height="400px" id = "previewImage" src ="https://5.imimg.com/data5/CK/LM/MY-46960546/fresh-red-strawberry-500x500.jpg"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Description </td>
                                        <td>
                                            <textarea id="txtDescription" style="width: 100%;height: 100px"></textarea>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Expired Date</td>
                                        <td>
                                            <input type="date" id="eDate" required=""/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Price (VND)</td>
                                        <td> <input type="number" id = "txtPrice" name="txtPrice" value="0" placeholder="1000"  placeholder="Product original price"   required/> </td>
                                    </tr>
                                    <tr>
                                        <td>Discount </td>
                                        <td>
                                            <input type="range" name="range" id="range" min="0" max="100" step="" value="0"  class="slider"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td> </td>
                                        <td>
                                            <input type="text" id='output' style="width: 30px"><span>%</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Seling Price (VND)   </td>
                                        <td>
                                            <span id='calPrice'>0 </span>
                                        </td>
                                    </tr>

                                </tbody>
                            </table>

                    </div>
                    <div class="modal-footer" style="align-items: center;align-content: center">

                        <input type="submit" class="btn btn-primary" value="Save"/>
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                    </div>
                    </form>
                </div>
            </div>
        </div>


        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Custom scripts for all pages-->
        <script src="js/sb-admin-2.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
        <script>
                                            function uploadImg(event) {
                                                $('#previewImage').attr("src", URL.createObjectURL(event.target.files[0]));
                                            }
//                                            var initData = function () {
//                                                $('#dataTable').DataTable({
//                                                    "data": "data",
//                                                    "ajax": {
//                                                        "url": "api/product/getAllStoreProduct?id=1",
//                                                        "method": "GET"
//                                                    },
//                                                    "processing": false,
//                                                    "serverSide": false,
//                                                    "columns": [
//                                                        {"data": "image"},
//                                                        {"data": "name"},
//                                                        {"data": "discPrice"},
//                                                        {"data": "totalQuantity"},
//                                                        {"data": "soldNum"},
//                                                        {"data": "inStock"},
//                                                        {"data": "expireDate"},
//                                                        {"data": "status"}
//                                                    ]
//                                                    , "destroy": true
//                                                });
//                                            };
                                            $('document').ready(function () {
                                                $('#searchOrder').submit(function (e) {
                                                    e.preventDefault();
                                                    $('#informationModal').modal();
                                                    if ($('#infoTable').find('td').find('input[id="btOrderConfirm"]').length <= 0) {
                                                        $('#infoTable').append("<tr><td colspan = '3'><input type='submit' value='Confirm' id='btOrderConfirm'/></td></tr>");
                                                    }
                                                });
                                                $('#informationModal').on("hidden.bs.modal", function () {
                                                    if ($('#infoTable').find('td').find('input[id="btOrderConfirm"]').length > 0) {
                                                        $('#btOrderConfirm').remove();
                                                    }
                                                });
                                                $('#range').on("input", function () {
                                                    $('#output').val(this.value);
                                                    var cal = Math.round((1 - this.value / 100) * $('#txtPrice').val() * 100) / 100;
                                                    $('#calPrice').html(cal);
                                                }).trigger("change");
                                                $('#output').change(function () {
                                                    $('#range').val(this.value);
                                                    var cal = Math.round((1 - this.value / 100) * $('#txtPrice').val() * 100) / 100;
                                                    $('#calPrice').html(cal);
                                                });
                                                $('#txtPrice').change(function () {
                                                    var cal = Math.round((1 - $('#range').value / 100) * $('#txtPrice').val() * 100) / 100;
                                                    $('#calPrice').html(cal);
                                                });
                                                $('#addProduct').submit(function (event) {
                                                    event.preventDefault;
                                                    $('#addProductModal').modal('hide');
                                                });
                                            }
                                            );
        </script>
    </body>

</html>
