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
                                    <span class="mr-2 d-none d-lg-inline text-gray-600 small">${sessionScope.user}</span>
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
                                    <h6 class="text-gray-500">Cannot find your product? <a class="link" href="#" data-toggle="modal" data-target="#createProductModal">Create a new one</a></h6>
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
                            <span aria-hidden="true">x</span>
                        </button>
                    </div>
                    <div class="modal-body">Select "Logout" below if you are ready to end your current session.</div>
                    <div class="modal-footer">
                        <button class="btn btn-secondary" type="button" data-dismiss="modal">Cancel</button>
                        <a class="btn btn-primary" href="logout">Logout</a>
                    </div>
                </div>
            </div>
        </div>


    </div>

    <!-- Add to store Modal-->
    <div class="modal fade" id="addProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Add to store</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="addProduct">
                        <input type="hidden" id="storeId" value="${sessionScope.store.storeId}"/>
                        <input type="hidden" id="productId"/>
                        <table border="0">
                            <tbody>
                                <tr>
                                    <td>Name</td>
                                    <td> <input type="text" name="name" id="name" value="" placeholder="Product name" required  style="width: 100%;border-top: none;border-left: none;border-right: none;"/> </td>
                                </tr>
                                <tr>
                                    <td >Image </td>
                                    <td >
                                        <input type="file" name="imageSrc" id="imageSrc" value="" onchange="uploadImg(event)"  />

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align:center">
                                        <img style ="max-width:300px;max-height:300px" id = "previewImage" name ="previewImage" />                               </td>
                                </tr>
                                <tr>
                                    <td>Description </td>
                                    <td>
                                        <textarea  id="description" style="width: 100%;height: 100px"></textarea>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Expired Date</td>
                                    <td>
                                        <input type="date" id="expiredDate" name="expiredDate" required=""/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Quantity</td>
                                    <td> <input type="number" id = "ammount" name="ammount" value="0" placeholder="1000"  placeholder="1"   required/>  </td>
                                </tr>
                                <tr>
                                    <td>Price (VND)</td>
                                    <td> <input type="number" id = "price" name="price" value="0" placeholder="1000"  placeholder="Product original price"   required/>   
                                        <!--<a onclick="suggestPrice()" href="#"> Suggest</a>-->
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


    <!-- Create New Product Modal-->
    <div class="modal fade" id="createProductModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">Send create new product request</h5>
                    <button class="close" type="button" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">x</span>
                    </button>
                </div>
                <div class="modal-body">
                    <form id="createProduct">
                        <table border="0" cellpadding="5">
                            <tbody>
                                <tr>
                                    <td>Name</td>
                                    <td> <input type="text" name="name" id="createName" value="" placeholder="Product name" required  style="width: 100%;border-top: none;border-left: none;border-right: none;"/> </td>
                                </tr>
                                <tr>
                                    <td >Image </td>
                                    <td >
                                        <input type="file" name="imageSrc" id="createImageSrc" value="" onchange="uploadImgCreate(event)"  />

                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="2" style="text-align:center">
                                        <img style ="max-width:300px;max-height:300px" id = "createPreviewImage" name ="previewImage" />                               </td>
                                </tr>

                                <tr>
                                    <td >Category </td>
                                    <td >
                                        <select name="category" id="createCategory">
                                        </select>
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
                                            function initCategory() {
                                                $.ajax({
                                                    url: "api/category/getAll",
                                                    method: "GET",
                                                    success: function (rs) {
                                                        var content="";
                                                        for(var i=0;i<rs.length;i++){
                                                            content+="<option value='"+rs[i].id+"'>"+rs[i].name+"</option>";
                                                        }
                                                        $('#createCategory').html(content);
                                                    }
                                                });
                                            }
                                            $('document').ready(function () {
                                                $('#resultTable').hide();
                                                initCategory();
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
                                                                {width: "60%", data:
                                                                            function (row, type, set) {
                                                                                if (type === 'display') {
                                                                                    var content = 'Name: ' + row.productName;
                                                                                    content += "<br>Category: " + row.category;
                                                                                    return content;
                                                                                }
                                                                                return "";
                                                                            }},
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
                                                });
                                                $('#txtPrice').change(function () {

                                                    var cal = Math.round((1 - $('#range').value / 100) * $('#txtPrice').val() * 100) / 100;
                                                    $('#calPrice').html(cal);
                                                });
                                                $('#addProduct').submit(function (event) {
                                                    event.preventDefault();
                                                    var form = $('#addProduct')[0];
                                                    var data = new FormData(form);
                                                    data.append("previewImage", $("#previewImage").attr("src"));
                                                    data.append("storeId",${sessionScope.store.storeId});
                                                    data.append("productId", $('#productId').val());
                                                    data.append("description", $('#description').val());
                                                    $.ajax({
                                                        url: "api/product/addProduct",
                                                        enctype: 'multipart/form-data',
                                                        method: "POST",
                                                        data: data, processData: false,
                                                        contentType: false,
                                                        cache: false,
                                                        timeout: 1000000,
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
                                                });
                                                $('#createProduct').submit(function (event) {
                                                    event.preventDefault();
                                                    var form = $('#createProduct')[0];
                                                    var data = new FormData(form);
                                                    
                                                    data.append("storeId",${sessionScope.store.storeId});
                                                    data.append("category",$('#createCategory').val());
//                                                    alert($('#createCategory').val());
                                                    $.ajax({
                                                        url: "api/product/requestCreateProduct",
                                                        enctype: 'multipart/form-data',
                                                        method: "POST",
                                                        data: data, processData: false,
                                                        contentType: false,
                                                        cache: false,
                                                        timeout: 1000000,
                                                        success: function (rs) {
                                                            if (rs.result === true) {
                                                                alert(rs.msg);
                                                                $('#createProductModal').modal('hide');
                                                            } else {
                                                                alert(rs.msg);
                                                            }
                                                        }, error: function (err) {
                                                            console.log(err);
                                                        }
                                                    });
                                                });
                                            });
                                            function uploadImg(event) {
                                                $('#previewImage').attr("src", URL.createObjectURL(event.target.files[0]));
                                            }
                                            function uploadImgCreate(event) {
                                                $('#createPreviewImage').attr("src", URL.createObjectURL(event.target.files[0]));
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
                                                        $('#name').val(data.productName);
                                                        $('#previewImage').attr("src", data.imageSrc);
                                                        $('#addProductModal').modal('show');
                                                    }
                                                });
                                            }

    </script>
</body>

</html>

