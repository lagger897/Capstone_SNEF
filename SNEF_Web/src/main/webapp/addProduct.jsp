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
        <title>SAFO- Sale Food</title>

        <!-- Custom fonts for this template -->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://fonts.googleapis.com/css?family=Nunito:200,200i,300,300i,400,400i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">

        <!-- Custom styles for this template -->
        <link href="css/sb-admin-2.min.css" rel="stylesheet">

        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">

        <style>
            input[type=text], input[type=number],input[type=date]{
                border-top: none;border-left: none;border-right: none;
            }
            #resultTable td{
                text-align: center;
                align-content: center;
                vertical-align: middle;
            }
        </style>
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
                <li class="nav-item active">
                    <a class="nav-link collapsed "  href="addStoreProduct" />
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
                                    <button class="btn btn-primary" type="submit" form="searchOrder">
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
                            <div class="topbar-divider d-none d-sm-block">

                            </div>



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
                        <div class="card shadow mb-4">
                            <div class="card-header py-3">
                                <h4 class="m-0 font-weight-bold text-primary" style="float:left">Search For Product</h4>
                            </div>
                            <div class="card-body">
                                <h6 class="text-gray-400">Search existed product before creating a new product</h6>
                                <form method="POST" name="searchProduct" id="searchProduct" action="WEB-INF/jsp/homepage.jsp">
                                    <div class="input-group">
                                        <input id="txtSearchProduct" type="text" class="form-control bg-light border-0 small" placeholder="Check code product ..." aria-label="Search" aria-describedby="basic-addon2">
                                        <div class="input-group-append">
                                            <button class="btn btn-primary" type="submit" form="searchProduct" >
                                                <i class="fas fa-search fa-sm"></i>
                                            </button>
                                        </div>
                                    </div>
                                </form>
                                <br>
                                <div class="input-group">
                                    <h6 class="text-gray-500">Cannot find your product? <a class="link" href="#">Create a new one</a></h6>
                                </div>

                                <hr>
                            </div>
                            <div class="card-body" id="resultTable" name="resultTable">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Image</th>
                                                <th>Product Information</th>
                                                <th>Action</th>
                                            </tr>
                                        </thead>
                                        <tfoot>
                                            <tr>
                                                <th>Image</th>
                                                <th>Product Information</th>
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
    </div>

    <!-- Post Sale Modal Modal-->
    <div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Post Sale</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">�</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addProduct">
                        <input type="hidden" id="productId"/>
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>Name</td>
                                    <td> <input type="text" name="txtName" id="txtName" value="Coca Cola" placeholder="Product name" required  style="width: 100%;border-top: none;border-left: none;border-right: none;"/> </td>
                                </tr>
                                <tr>
                                    <td >Image </td>
                                    <td > <input type="file" name="txtFile" id="txtFile" value="" onchange="uploadImg(event)"  /> </td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align:center">
                                        <img style ="max-width:300px;max-height:300px" id = "previewImage" src ="data:image/jpeg;base64,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"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Description </td>
                                    <td>
                                        <textarea id="txtDescription" style="width: 100%;height: 100px">Good soft drink</textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Expired Date</td>
                                    <td>
                                        <input type="date" id="eDate" required=""/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Quantity</td>
                                    <td> <input type="number" id = "txtAmmount" name="txtAmmount" value="0" placeholder="1000"  placeholder="1"   required/>  </td>
                                </tr>
                                <tr>
                                    <td>Price (VND)</td>
                                    <td> <input type="number" id = "txtPrice" name="txtPrice" value="0" placeholder="1000"  placeholder="Product original price"   required/>   
                                        <!--<a onclick="suggestPrice()" href="#"> Suggest</a>-->
                                    </td>
                                </tr>
                                <!--                                <tr>
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
                                                                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
                                                                        <span id='sugPrice'> </span>
                                                                    </td>
                                                                </tr>-->

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

    <!-- Bootstrap core JavaScript-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

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
                                            $('#resultTable').hide();
                                            $('#searchProduct').submit(function (e) {
                                                e.preventDefault();
                                                var search = $('#txtSearchProduct').val().trim();
                                                if (search !== "") {
                                                    $('#dataTable').dataTable({
                                                        "ajax": {
                                                            "url": "api/product/search?name=" + search,
                                                            "method": "GET", "dataType": "json"
                                                        },
                                                        "processing": true,
                                                        "serverSide": false,

                                                        "columns": [
                                                            {width: "25%", data: function (row, type, set) {
                                                                    if (type === 'display') {
                                                                        return "<img src='" + row.imageSrc + "' width=200px;height=200px />";
                                                                    }
                                                                    return "";
                                                                }},
                                                            {width: "60%", data: "productName"},
                                                            {width: "15%", data: function (row, type, set) {
                                                                    if (type === 'display') {
                                                                        var content = '<input type="button" value="Select" onclick="getProduct(' + row.productId + ')" style="width:200px">';
                                                                        return content;
                                                                    }
                                                                    return "";
                                                                }}],
                                                        destroy: true,
                                                    });

                                                    $('#resultTable').show();
                                                } else {
                                                    $('#resultTable').hide();
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
                                            })
                                            $('#txtPrice').change(function () {

                                                var cal = Math.round((1 - $('#range').value / 100) * $('#txtPrice').val() * 100) / 100;
                                                $('#calPrice').html(cal);
                                            })
                                            $('#addProduct').submit(function (event) {
                                                event.preventDefault();
//                                                alert("Add Product");
//                                                alert($('#productId').val());
                                                $.ajax({
                                                    url: "api/product/addProduct",
                                                    method: "POST",
                                                    data: JSON.stringify({
                                                        "storeId": ${sessionScope.store.storeId},
                                                        "productId": $('#productId').val(),
                                                        "name": $('#txtName').val(),
                                                        "imageSrc": $('#previewImage').attr('src'),
                                                        "description": $('#txtDescription').html(),
                                                        "expiredDate": $('#eDate').val(),
                                                        "ammount": $('#txtAmmount').val(),
                                                        "price": $('#txtPrice').val()
                                                    }),
                                                    dataType: "json",
                                                    contentType: "application/json; charset=utf-8",
                                                    success: function (rs) {
                                                        if (rs.result === true) {
                                                            alert(rs.msg);
                                                            $('#addProductModal').modal('hide');
                                                        } else {
                                                            alert(rs.msg);
                                                        }
                                                    }, error: function (err) {
                                                        console.log(err);
                                                    }
                                                });
                                            })
                                        });
                                        function uploadImg(event) {
                                            $('#previewImage').attr("src", URL.createObjectURL(event.target.files[0]));

                                        }
                                        function suggestPrice() {
                                            $('#sugPrice').html(10000);
                                        }
                                        function getProduct(id) {
                                            $.ajax({
                                                url: "api/product/getProduct?id=" + id,
                                                method: "GET",
                                                dataType: "json",
                                                success: function (data) {
                                                    $('#productId').val(data.productId);
                                                    $('#txtName').val(data.productName);
                                                    $('#previewImage').attr("src", data.imageSrc);
                                                    $('#addProductModal').modal('show');
                                                }
                                            });
                                        }

    </script>
</body>

</html>

