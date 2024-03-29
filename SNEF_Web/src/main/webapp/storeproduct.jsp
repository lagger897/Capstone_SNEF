<%-- 
    Document   : storeproducepage
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

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="css/inputRange.css" rel="stylesheet">
        <style>
            input[type=text], input[type=number],input[type=date]{
                border-top: none;border-left: none;border-right: none;
            }
            #editStoreProduct td{
                padding: 5px;
            }
        </style>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <link href="css/inputRange.css" rel="stylesheet"/>
        <script>
            $('document').ready(function () {
                $table = $('#dataTable').dataTable({
                    "ajax": {
                        "url": "api/product/getAllStoreProductWithoutFlashSale?storeId="+${sessionScope.store.storeId},
                        "method": "GET",
                        "dataType": "json"
                    },
                    "processing": true,
                    "serverSide": false,
                    "columns": [

                        {width: "5%", data: "storeProductId"},
                        {width: "20%", data: "name"},
                        {data: function (row, type, set) {
//                                alert(type);
                                if (type === 'display') {
                                    return "<img src='" + row.imageSrc + "' width=70px;height=30px />";
                                }
                                return "";
                            }},
                        {data: "price"},
                        {width: "10%", data: "expiredDate"},
                        {width: "5%", data: "quantity"},
                        {width: "10%", data: function (row, type, set) {
                                return row.sku !== null ? row.sku : "";
                            }},
                        {width: "60px", data: function (row, type, set) {
                                if (type === 'display') {
                                    var content = "<ul class='navbar-nav '>";
                                    content += '<li class="nav-item"><a class="nav-link" href="#" onclick="saleProduct(' + row.storeProductId + ',' + row.price + ',' + row.expiredDate + ')" ><i class="fas fa-fw fa-cart-plus"></i><span style="color:black"> Sale</span></a><li>';
                                    content += '<li class="nav-item"><a class="nav-link" href="#" onclick="editProduct(' + row.storeProductId + ')" ><i class="fas fa-edit" ></i><span style="color:black"> Edit</span></a><li>';
                                    content += '<li class="nav-item"><a class="nav-link" href="#" onclick="deleteProduct(' + row.storeProductId + ')"><i class="fas fa-fw fa-trash" ></i><span style="color:black"> Delete</span></a><li>';
                                    content += "<ul>";
                                    //content += '<input type="button" value="Edit" onclick="" style="width:70px"><br><br>';
                                    //content += '<input type="button" value="Delete" onclick="" style="width:70px">';
                                    return content;
                                }
                                return "";
                            }},
                    ]
                            //                    , "destroy": true
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
                <li class="nav-item ">
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
                <li class="nav-item active">
                    <a class="nav-link collapsed "  href="storeProduct" />
                    <i class="fas fa-fw fa-folder"></i>
                    <span>Store Product</span>
                    </a>
                </li>
                <!-- Nav Item - Pages Collapse Menu -->
                <li class="nav-item">
                    <a class="nav-link collapsed "  href="order" />
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
                                <h4 class="m-0 font-weight-bold text-primary" style="float:left">Product In Store </h4>
                                <!--<input type="button" value="Post Sale" data-toggle="modal" data-target="#saleProductModal" style="float:right" class="btn btn-link rounded-circle mr-3"/>-->
                            </div>
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Product Id</th>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Price Per Unit</th>
                                                <th>Expired Date</th> 
                                                <th>Quantity</th>
                                                <th>SKU</th>
                                                <!--<th>Last Update</th>-->
                                                <th>Action</th>

                                            </tr>
                                        </thead>
                                        <tbody></tbody>
                                        <tfoot>
                                            <tr>
                                                <th>Product Id</th>
                                                <th>Name</th>
                                                <th>Image</th>
                                                <th>Price Per Unit</th>
                                                <th>Expired Date</th> 
                                                <th>Quantity</th>
                                                <th>SKU</th>
                                                <!--<th>Last Update</th>-->
                                                <th>Action</th>
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
                            <span aria-hidden="true">�</span>
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
                            <span aria-hidden="true">�</span>
                        </button>
                    </div>
                    <div class="modal-body" style="text-align: center;align-items: center">
                        <form>
                            <table border="0" cellspacing="1" cellpadding="1" style="margin: 0 auto;width: 100%" id="infoTable">
                                <tbody>
                                    <tr>
                                        <td colspan="3" style="text-align: center"><h3 class=""><b>B�ch H�a Xanh</b></h3></td>
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
        <!-- Post Sale  Modal-->
        <div class="modal fade" id="saleProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel">Post Sale</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">�</span>
                        </button>
                    </div>
                    <form id="addSale">
                        <div class="modal-body">
                            <table border="0" style="margin:0 auto">
                                <tbody>
                                    <tr>
                                        <td>Start Date</td>
                                        <td>
                                            <input type="date" id="sDate" name="sDate" required="" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>End Date</td>
                                        <td>
                                            <input type="date" id="eDate" name="eDate" required=""/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Quantity</td>
                                        <td> <input type="number" id = "txtQuantity" name="txtQuantity" required/> </td>
                                    </tr>
                                    <tr>
                                        <td>Price (VND)</td>
                                        <td> <input type="number" id = "txtPrice" name="txtPrice" disabled/> </td>
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
                                            <input type="text" id='output' style="width: 30px" value="0"><span>%</span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Seling Price (VND)   </td>
                                        <td>
                                            <span id='calPrice'>0 </span>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><span id="saleProductError" style="color: red"></span></td>
                                    </tr>

                                </tbody>
                            </table>
                            <input type="hidden" id="hiddenStoreProductId"/>
                            <input type="hidden" id="hiddenExpiredDate"/>

                        </div>
                        <div class="modal-footer" style="align-items: center;align-content: center">

                            <button class="btn btn-secondary" type="button" >Suggest</button>
                            <input type="submit" class="btn btn-primary" value="Save"/>
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
        <!-- Edit Sale Modal-->
        <div class="modal fade " id="editProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" >Edit In Store Product</h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">�</span>
                        </button>
                    </div>
                    <form id="editStoreProduct">
                        <div class="modal-body">
                            <input type="hidden" id="hiddenEditStoreProductId"/>
                            <table border="0" style="margin:0 auto">
                                <tbody>
                                    <tr>
                                        <td>Image</td>
                                        <td>
                                            <img id="editImage" style="width:300px;height:300px"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Change Image</td>
                                        <td>
                                            <input type="file" id ="editImageFile" value="" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Name</td>
                                        <td> <input type="text" id = "txtEditName" id = "txtEditName"  required/> </td>
                                    </tr>
                                    <tr>
                                        <td>Description</td>
                                        <td> <textarea style="width:300px;height: 300px" id="txtEditDescription"></textarea> </td>
                                    </tr>
                                    <tr>
                                        <td>Price </td>
                                        <td>
                                            <input type="number" id="txtEditPrice" required/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Expired Date</td>
                                        <td>
                                            <input type="date" required id="editExpiredDate"/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>Quantity</td>
                                        <td>
                                            <input type='number' required id='editQuantity'/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>SKU</td>
                                        <td>
                                            <input type='text' id='editSKU'/>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td colspan="2"><span id="editProductError" style="color: red"></span></td>
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

        <!-- Delete Modal-->
        <div class="modal fade" id="deleteProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
            <div class="modal-dialog" role="document">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="exampleModalLabel"><b>Are you sure to delete?</b></h5>
                        <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                            <span aria-hidden="true">�</span>
                        </button>
                    </div>
                    <div class="modal-body">This will delete in store product and all sales with it. Press "Delete" if you are sure </div>

                    <div class="modal-footer">
                        <form id="deleteProductForm">
                            <input type='hidden' id="hiddenDeleteProductId"/>
                            <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                            <input type='submit' class="btn btn-primary" value="Delete" ></a>
                        </form>
                    </div>
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
        <script> function saleProduct(productId, price, expiredDate) {
                $('#saleProductModal').modal('show');
                $('#txtPrice').val(price);
                $('#hiddenStoreProductId').val(productId);
                $('#hiddenExpiredDate').val(expiredDate);
            }
            function editProduct(productId) {
                $.ajax({
                    url: "api/product/getStoreProduct?id=" + productId,
                    type: 'GET', success: function (data) {
                        $("#editImage").attr("src", data.imageSrc);
                        $("#txtEditName").val(data.name);
                        $("#txtEditDescription").val(data.description);
                        $("#txtEditPrice").val(data.price);
                        $("#editExpiredDate").val(data.expiredDate);
                        $("#editQuantity").val(data.quantity);
                        $("#editSKU").val(data.sku);
                        $("#hiddenStoreProductId").val(data.storeProductId);
                    }
                });
                $('#editProductModal').modal('show');
            }
            function deleteProduct(productId) {
                $('#deleteProductModal').modal('show');
                $('#hiddenDeleteProductId').val(productId);
//                $('#dataTable').DataTable().ajax.reload();
            }


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
                $('#addSale').submit(function (event) {
                    event.preventDefault();
                    var expiredDate = new Date($('#hiddenExpiredDate').val());
                    var startDate = new Date($('#sDate').val());
                    var endDate = new Date($('#eDate').val());
                    var curDate = new Date();
                    $.ajax({
                        url: "api/product/saleStoreProduct", type: 'POST',
                        data: JSON.stringify({"storeProductId": $('#hiddenStoreProductId').val(),
                            "startDate": $('#sDate').val(),
                            "endDate": $('#sDate').val(),
                            "quantity": $('#txtQuantity').val(),
                            "discount": $('#output').val(),
                        }), dataType: "json", contentType: "application/json", success: function (result) {
                            if (result.result === true) {
                                alert(result.msg);
                                $('#saleProductModal').modal('hide');
                                $('#dataTable').DataTable().ajax.reload();
                            } else {
                                $('#saleProductError').html(result.msg);
                            }

                        }, error: function (err) {
                            $('#saleProductError').html(err);
                        }
                    });
                });
                $('#deleteProductForm').submit(function (event) {
                    event.preventDefault();
                    $.ajax({
                        url: "api/product/deleteStoreProduct?productId=" + $('#hiddenDeleteProductId').val(),
                        type: "PUT", success: function (data) {
                            if (data.result) {
                                $('#dataTable').DataTable().ajax.reload();
                                $('#deleteProductModal').modal("hide");
                            } else {
                                alert(data.msg);
                            }

                        }
                    });
                })
                $('#editStoreProduct').submit(function (event) {
                    event.preventDefault();
                    $.ajax({
                        url: "api/product/updateStoreProduct",
                        type: "POST", dataType: "json", contentType: "application/json",
                        data: JSON.stringify({
                            "storeProductId": $("#hiddenStoreProductId").val(),
                            "imageSrc": $("#editImage").attr("src"),
                            "name": $("#txtEditName").val(),
                            "expiredDate": $("#editExpiredDate").val(),
                            "quantity": $("#editQuantity").val(),
                            "price": $("#txtEditPrice").val(),
                            "description": $("#txtEditDescription").val(),
                            "sku": $("#editSKU").val()
                        })
                        , success: function (data) {
                            if (data.result) {
                                $('#dataTable').DataTable().ajax.reload();
                                $('#editProductModal').modal("hide");
                            } else {
                                alert(data.msg);
                            }

                        }
                    });
                }
                )
            });
        </script>
    </body>
</html>

