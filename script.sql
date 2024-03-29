USE [SNEF_Part2]
GO
/****** Object:  Table [dbo].[Account]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Account](
	[AccountId] [int] IDENTITY(1,1) NOT NULL,
	[UserName] [nvarchar](30) NOT NULL,
	[Password] [nvarchar](30) NOT NULL,
	[FirstName] [nvarchar](20) NOT NULL,
	[LastName] [nvarchar](20) NOT NULL,
	[Phone] [varchar](20) NULL,
	[Email] [varchar](50) NULL,
	[IsActive] [bit] NOT NULL,
	[Avatar] [varchar](400) NULL,
PRIMARY KEY CLUSTERED 
(
	[AccountId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Categories]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Categories](
	[CategoriesId] [int] IDENTITY(1,1) NOT NULL,
	[CategoryName] [nvarchar](30) NOT NULL,
	[ImageSrc] [nvarchar](400) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CategoriesId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[City]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[City](
	[CityId] [int] IDENTITY(1,1) NOT NULL,
	[CityName] [nvarchar](20) NOT NULL,
	[CountryId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CityId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Configuration]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Configuration](
	[configurationId] [int] IDENTITY(1,1) NOT NULL,
	[configurationName] [varchar](30) NOT NULL,
	[configurationValue] [nvarchar](500) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[configurationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Country]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Country](
	[CountryId] [int] IDENTITY(1,1) NOT NULL,
	[CountryName] [nvarchar](20) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CountryId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Customer]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Customer](
	[CustomerId] [int] IDENTITY(1,1) NOT NULL,
	[AccountId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[District]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[District](
	[DistrictId] [int] IDENTITY(1,1) NOT NULL,
	[DistrictName] [nvarchar](20) NOT NULL,
	[WardId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[DistrictId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FlashSaleProduct]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FlashSaleProduct](
	[FlashSaleProductId] [int] IDENTITY(1,1) NOT NULL,
	[Quantity] [int] NOT NULL,
	[StoreProductId] [int] NOT NULL,
	[FlashSalesId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[FlashSaleProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[FlashSales]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[FlashSales](
	[FlashSalesId] [int] IDENTITY(1,1) NOT NULL,
	[StoreId] [int] NOT NULL,
	[Discount] [int] NOT NULL,
	[StartDate] [datetime] NOT NULL,
	[EndDate] [datetime] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[FlashSalesId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Like]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Like](
	[LikeId] [int] IDENTITY(1,1) NOT NULL,
	[CustomerId] [int] NOT NULL,
	[StoreProductId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[LikeId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Location]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Location](
	[LocationId] [int] IDENTITY(1,1) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[DistrictId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[LocationId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Order]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Order](
	[OrderId] [int] IDENTITY(1,1) NOT NULL,
	[DateOrder] [datetime] NOT NULL,
	[TotalPrice] [float] NOT NULL,
	[ConfirmationCode] [varchar](50) NOT NULL,
	[OrderQuantity] [int] NOT NULL,
	[Status] [bit] NOT NULL,
	[RatingPoint] [float] NULL,
	[CustomerCustomerId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[OrderDetail]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[OrderDetail](
	[OrderDetailId] [int] IDENTITY(1,1) NOT NULL,
	[OrderOrderId] [int] NOT NULL,
	[FlashSaleProductId] [int] NOT NULL,
	[Quantity] [int] NOT NULL,
	[OrderDetailPrice] [float] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[OrderDetailId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[Product]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Product](
	[ProductId] [int] IDENTITY(1,1) NOT NULL,
	[CategoriesId] [int] NOT NULL,
	[ProductName] [nvarchar](50) NOT NULL,
	[ImageSrc] [varchar](400) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[ProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Store]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Store](
	[StoreId] [int] IDENTITY(1,1) NOT NULL,
	[StoreName] [nvarchar](50) NOT NULL,
	[LocationId] [int] NOT NULL,
	[RatingPoint] [float] NULL,
	[Avatar] [varchar](400) NULL,
	[OpenHour] [varchar](5) NOT NULL,
	[CloseHour] [varchar](5) NOT NULL,
	[StoreManagerId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[StoreId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StoreFollwer]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StoreFollwer](
	[StoreFollower] [int] IDENTITY(1,1) NOT NULL,
	[StoreId] [int] NOT NULL,
	[CustomerId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[StoreFollower] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StoreManager]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[StoreManager](
	[StoreManagerId] [int] IDENTITY(1,1) NOT NULL,
	[AccountId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[StoreManagerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[StoreProduct]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StoreProduct](
	[StoreProductId] [int] IDENTITY(1,1) NOT NULL,
	[StoreId] [int] NOT NULL,
	[ProductId] [int] NOT NULL,
	[ProductName] [nvarchar](50) NOT NULL,
	[ExpiredDate] [datetime] NOT NULL,
	[Quantity] [int] NOT NULL,
	[Price] [float] NULL,
	[Description] [nvarchar](4000) NULL,
	[SKU] [varchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[StoreProductId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[StoreProductImage]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[StoreProductImage](
	[FSPId] [int] IDENTITY(1,1) NOT NULL,
	[ImageSrc] [varchar](400) NOT NULL,
	[StoreProductId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[FSPId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Ward]    Script Date: 6/23/2019 3:19:11 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Ward](
	[WardId] [int] IDENTITY(1,1) NOT NULL,
	[WardName] [nvarchar](20) NOT NULL,
	[CityId] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[WardId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET IDENTITY_INSERT [dbo].[Account] ON 

INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (1, N'TinLM', N'123', N'Tín', N'Lê', N'0774203847', N'tin@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561088200/avatar/account/TinLM.jpg')
INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (2, N'DuyAn', N'123', N'Duy', N'An', N'0789451184', N'an@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561088370/avatar/account/DuyAn.jpg.jpg')
INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (3, N'ThienLT', N'123', N'Thiện', N'Lâm', N'0985858847', N'thien@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561088309/avatar/account/ThienLT.jpg')
INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (4, N'HieuTB', N'123', N'Hiếu', N'Bảo', N'0777777778', N'hieu@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561088269/avatar/account/BaoHieu.jpg')
INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (5, N'NamD', N'123', N'Nam', N'Đặng', N'0775203954', N'nam@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561090785/avatar/account/NamDHP.jpg')
INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (6, N'VuongDM', N'123', N'Vương', N'Đinh', N'0778587187', N'vuong@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561090839/avatar/account/VuongDM.jpg')
INSERT [dbo].[Account] ([AccountId], [UserName], [Password], [FirstName], [LastName], [Phone], [Email], [IsActive], [Avatar]) VALUES (7, N'ThuyN', N'123', N'Thùy', N'Nguyễn', N'086534556', N'thuy@gmail.com', 1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561090894/avatar/account/Th%C3%B9y%20Nguyen.jpg')
SET IDENTITY_INSERT [dbo].[Account] OFF
SET IDENTITY_INSERT [dbo].[Categories] ON 

INSERT [dbo].[Categories] ([CategoriesId], [CategoryName], [ImageSrc]) VALUES (1, N'Ăn vặt & Bánh kẹo', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560490446/categories/snacks.png')
INSERT [dbo].[Categories] ([CategoriesId], [CategoryName], [ImageSrc]) VALUES (2, N'Đồ uống', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560490446/categories/drinks.png')
INSERT [dbo].[Categories] ([CategoriesId], [CategoryName], [ImageSrc]) VALUES (3, N'Đồ hộp & đóng gói', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560490301/categories/cannedfood.png')
INSERT [dbo].[Categories] ([CategoriesId], [CategoryName], [ImageSrc]) VALUES (4, N'Nông sản', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560490446/categories/fruit.png')
INSERT [dbo].[Categories] ([CategoriesId], [CategoryName], [ImageSrc]) VALUES (5, N'Gia vị', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560782504/categories/spice.png')
SET IDENTITY_INSERT [dbo].[Categories] OFF
SET IDENTITY_INSERT [dbo].[City] ON 

INSERT [dbo].[City] ([CityId], [CityName], [CountryId]) VALUES (1, N'Hồ Chí Minh', 1)
INSERT [dbo].[City] ([CityId], [CityName], [CountryId]) VALUES (2, N'Hà Nội', 1)
INSERT [dbo].[City] ([CityId], [CityName], [CountryId]) VALUES (3, N'Đà Nẳng', 1)
SET IDENTITY_INSERT [dbo].[City] OFF
SET IDENTITY_INSERT [dbo].[Configuration] ON 

INSERT [dbo].[Configuration] ([configurationId], [configurationName], [configurationValue]) VALUES (1, N'ApiURL', N'http://192.168.100.5:8080/')
SET IDENTITY_INSERT [dbo].[Configuration] OFF
SET IDENTITY_INSERT [dbo].[Country] ON 

INSERT [dbo].[Country] ([CountryId], [CountryName]) VALUES (1, N'Vietnam')
SET IDENTITY_INSERT [dbo].[Country] OFF
SET IDENTITY_INSERT [dbo].[Customer] ON 

INSERT [dbo].[Customer] ([CustomerId], [AccountId]) VALUES (1, 1)
INSERT [dbo].[Customer] ([CustomerId], [AccountId]) VALUES (2, 2)
SET IDENTITY_INSERT [dbo].[Customer] OFF
SET IDENTITY_INSERT [dbo].[District] ON 

INSERT [dbo].[District] ([DistrictId], [DistrictName], [WardId]) VALUES (1, N'Phường 4', 1)
INSERT [dbo].[District] ([DistrictId], [DistrictName], [WardId]) VALUES (2, N'Phường 12', 1)
INSERT [dbo].[District] ([DistrictId], [DistrictName], [WardId]) VALUES (3, N'Phường 13', 1)
INSERT [dbo].[District] ([DistrictId], [DistrictName], [WardId]) VALUES (4, N'P. Tân Thới Nhì', 2)
SET IDENTITY_INSERT [dbo].[District] OFF
SET IDENTITY_INSERT [dbo].[FlashSaleProduct] ON 

INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (1, 100, 1, 1)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (2, 50, 2, 3)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (3, 100, 3, 5)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (4, 50, 4, 7)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (5, 100, 5, 9)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (6, 50, 6, 2)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (7, 50, 7, 4)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (8, 20, 8, 6)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (9, 100, 9, 8)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (10, 150, 10, 10)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (11, 100, 11, 1)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (12, 80, 12, 3)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (13, 50, 13, 5)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (14, 80, 14, 7)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (15, 100, 15, 9)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (16, 70, 16, 2)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (17, 100, 17, 4)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (18, 70, 18, 6)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (19, 40, 19, 8)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (20, 70, 20, 10)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (21, 40, 21, 1)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (22, 70, 22, 3)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (23, 40, 23, 5)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (24, 70, 24, 7)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (25, 100, 25, 2)
INSERT [dbo].[FlashSaleProduct] ([FlashSaleProductId], [Quantity], [StoreProductId], [FlashSalesId]) VALUES (26, 50, 26, 9)
SET IDENTITY_INSERT [dbo].[FlashSaleProduct] OFF
SET IDENTITY_INSERT [dbo].[FlashSales] ON 

INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (1, 1, 50, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (2, 1, 60, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (3, 2, 50, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (4, 2, 70, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (5, 3, 50, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (6, 3, 80, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (7, 4, 50, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (8, 4, 65, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (9, 5, 50, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
INSERT [dbo].[FlashSales] ([FlashSalesId], [StoreId], [Discount], [StartDate], [EndDate]) VALUES (10, 5, 75, CAST(N'2019-06-01 00:00:00.000' AS DateTime), CAST(N'2019-06-30 00:00:00.000' AS DateTime))
SET IDENTITY_INSERT [dbo].[FlashSales] OFF
SET IDENTITY_INSERT [dbo].[Location] ON 

INSERT [dbo].[Location] ([LocationId], [Address], [DistrictId]) VALUES (1, N'18 Cộng Hòa', 1)
INSERT [dbo].[Location] ([LocationId], [Address], [DistrictId]) VALUES (2, N'225A Hoàng Hoa Thám', 2)
INSERT [dbo].[Location] ([LocationId], [Address], [DistrictId]) VALUES (3, N'17 Cộng Hòa', 1)
INSERT [dbo].[Location] ([LocationId], [Address], [DistrictId]) VALUES (4, N'98/1A Lê Lợi, Ấp Dân Thắng 2', 4)
INSERT [dbo].[Location] ([LocationId], [Address], [DistrictId]) VALUES (5, N' 50 Nhất Chi Mai', 3)
SET IDENTITY_INSERT [dbo].[Location] OFF
SET IDENTITY_INSERT [dbo].[Product] ON 

INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (1, 1, N'Kẹo milo Cube 100 viên', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560059650/snack/K%E1%BA%B9o%20Milo%20Cube%20100%20vi%C3%AAn.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (2, 1, N'Kẹo dưa hấu Thái Lan 22g', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560060997/snack/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20th%C3%A1i%20lan%2022g.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (3, 2, N'Bò cụng', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1559152806/Drink/bocunglon.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (4, 2, N'Pepsi 1.25l', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1559152745/Drink/pepsi1.25.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (5, 2, N'Sting dâu', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1559152605/Drink/stingdauchai.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (6, 3, N'Bò hầm Vissan', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1559600305/canned/bohamVissan.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (7, 3, N'Thịt heo hormel', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1559600208/canned/thitheoHormel.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (8, 3, N'Cá hộp 3 cô gái', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1559154063/canned/casotkhui3cogai.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (9, 5, N'Tương ớt Chinsu', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560061568/spice/T%C6%B0%C6%A1ng%20%E1%BB%9Bt%20chinsu.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (10, 5, N' Hạt Nêm CHIN-SU', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560061665/spice/%20H%E1%BA%A1t%20N%C3%AAm%20CHIN-SU.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (11, 5, N'Nước mắm Nam Ngư Phú Quốc', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560061741/spice/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (12, 4, N'Gạo Sạch Làng Ta Vua Gạo 5kg', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560061869/fruitandvegetables/G%E1%BA%A1o%20S%E1%BA%A1ch%20L%C3%A0ng%20Ta%20Vua%20G%E1%BA%A1o%205kg.jpg')
INSERT [dbo].[Product] ([ProductId], [CategoriesId], [ProductName], [ImageSrc]) VALUES (13, 3, N'CÁ CAPELIN 500G', N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1560063481/food/C%C3%81%20CAPELIN%20500G.jpg')
SET IDENTITY_INSERT [dbo].[Product] OFF
SET IDENTITY_INSERT [dbo].[Store] ON 

INSERT [dbo].[Store] ([StoreId], [StoreName], [LocationId], [RatingPoint], [Avatar], [OpenHour], [CloseHour], [StoreManagerId]) VALUES (1, N'Circle K Viet Nam', 1, NULL, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561089795/avatar/store/Circle%20K%20Viet%20Nam.jpg', N'24:00', N'24:00', 1)
INSERT [dbo].[Store] ([StoreId], [StoreName], [LocationId], [RatingPoint], [Avatar], [OpenHour], [CloseHour], [StoreManagerId]) VALUES (2, N'Circle K Hoang Hoa Tham', 1, NULL, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561089968/avatar/store/Circle%20K%20225A%20Ho%C3%A0ng%20Hoa%20Th%C3%A1m.jpg', N'24:00', N'24:00', 2)
INSERT [dbo].[Store] ([StoreId], [StoreName], [LocationId], [RatingPoint], [Avatar], [OpenHour], [CloseHour], [StoreManagerId]) VALUES (3, N'VinMart Cộng Hòa', 1, NULL, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561090068/avatar/store/%20VinMart%20C%E1%BB%99ng%20H%C3%B2a.jpg', N'8:00', N'22:00', 3)
INSERT [dbo].[Store] ([StoreId], [StoreName], [LocationId], [RatingPoint], [Avatar], [OpenHour], [CloseHour], [StoreManagerId]) VALUES (4, N'Siêu thị Bách hóa XANH 98/1A Lê Lợi', 1, NULL, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561090444/avatar/store/Si%C3%AAu%20th%E1%BB%8B%20B%C3%A1ch%20h%C3%B3a%20XANH%2098%201A%20L%C3%AA%20L%E1%BB%A3i.jpg', N'8:00', N'22:00', 4)
INSERT [dbo].[Store] ([StoreId], [StoreName], [LocationId], [RatingPoint], [Avatar], [OpenHour], [CloseHour], [StoreManagerId]) VALUES (5, N'Circle K Nhat Chi Mai', 1, NULL, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561090277/avatar/store/Circle%20K%2050%20Nh%E1%BA%A5t%20Chi%20Mai.jpg', N'24:00', N'24:00', 5)
SET IDENTITY_INSERT [dbo].[Store] OFF
SET IDENTITY_INSERT [dbo].[StoreManager] ON 

INSERT [dbo].[StoreManager] ([StoreManagerId], [AccountId]) VALUES (1, 3)
INSERT [dbo].[StoreManager] ([StoreManagerId], [AccountId]) VALUES (2, 4)
INSERT [dbo].[StoreManager] ([StoreManagerId], [AccountId]) VALUES (3, 5)
INSERT [dbo].[StoreManager] ([StoreManagerId], [AccountId]) VALUES (4, 6)
INSERT [dbo].[StoreManager] ([StoreManagerId], [AccountId]) VALUES (5, 7)
SET IDENTITY_INSERT [dbo].[StoreManager] OFF
SET IDENTITY_INSERT [dbo].[StoreProduct] ON 

INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (1, 1, 1, N'Kẹo milo Cube 100 viên', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 150000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (2, 2, 1, N'Kẹo milo Cube 100 viên', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 50, 120000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (3, 3, 2, N'Kẹo dưa hấu Thái Lan 22g', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 30000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (4, 4, 2, N'Kẹo dưa hấu Thái Lan 22g', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 50, 27000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (5, 5, 3, N'Bò cụng', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 10000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (6, 1, 3, N'Bò cụng', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 50, 10000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (7, 2, 4, N'Pepsi 1.25l', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 50, 20000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (8, 3, 4, N'Pepsi 1.25l', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 20, 20000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (9, 4, 5, N'Sting dâu', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 10000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (10, 5, 5, N'Sting dâu', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 150, 10000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (11, 1, 6, N'Bò hầm Vissan', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 60000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (12, 2, 6, N'Bò hầm Vissan', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 80, 55000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (13, 3, 7, N'Thịt heo hormel', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 50, 60000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (14, 4, 7, N'Thịt heo hormel', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 80, 55000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (15, 5, 8, N'Cá hộp 3 cô gái', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 15000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (16, 1, 8, N'Cá hộp 3 cô gái', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 70, 20000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (17, 2, 9, N'Tương ớt Chinsu', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 15000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (18, 3, 9, N'Tương ớt Chinsu', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 70, 12000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (19, 4, 10, N' Hạt Nêm CHIN-SU 800g', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 40, 35000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (20, 5, 10, N' Hạt Nêm CHIN-SU 400g', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 70, 18000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (21, 1, 11, N'Nước mắm Nam Ngư Phú Quốc 500ml', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 40, 50000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (22, 2, 11, N'Nước mắm Nam Ngư Phú Quốc 500ml', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 70, 50000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (23, 3, 12, N'Gạo Sạch Làng Ta Vua Gạo 5kg', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 40, 100000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (24, 4, 12, N'Gạo Sạch Làng Ta Vua Gạo 5kg', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 70, 90000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (25, 1, 13, N'CÁ CAPELIN 500G', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 100, 20000, NULL, NULL)
INSERT [dbo].[StoreProduct] ([StoreProductId], [StoreId], [ProductId], [ProductName], [ExpiredDate], [Quantity], [Price], [Description], [SKU]) VALUES (26, 5, 13, N'CÁ CAPELIN 500G', CAST(N'2019-06-30 00:00:00.000' AS DateTime), 50, 19000, NULL, NULL)
SET IDENTITY_INSERT [dbo].[StoreProduct] OFF
SET IDENTITY_INSERT [dbo].[StoreProductImage] ON 

INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (1, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture1.jpg', 1)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (2, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture2.jpg', 1)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (3, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture3.jpg', 1)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (4, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture4.jpg', 1)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (5, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture1.jpg', 2)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (6, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture2.jpg', 2)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (7, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture3.jpg', 2)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (8, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561095294/snack/listImage/K%E1%BA%B9o%20milo%20Cube%20100%20vi%C3%AAn/picture4.jpg', 2)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (9, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561257819/snack/listImage/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20Th%C3%A1i%20Lan%2022g/picture1.jpg', 3)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (10, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561257819/snack/listImage/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20Th%C3%A1i%20Lan%2022g/picture2.jpg', 3)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (11, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561257819/snack/listImage/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20Th%C3%A1i%20Lan%2022g/picture3.jpg', 3)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (12, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561257819/snack/listImage/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20Th%C3%A1i%20Lan%2022g/picture1.jpg', 4)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (13, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561257819/snack/listImage/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20Th%C3%A1i%20Lan%2022g/picture2.jpg', 4)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (14, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561257819/snack/listImage/K%E1%BA%B9o%20d%C6%B0a%20h%E1%BA%A5u%20Th%C3%A1i%20Lan%2022g/picture3.jpg', 4)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (15, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258036/Drink/list%20image/B%C3%B2%20C%E1%BB%A4ng/picture1.jpg', 5)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (16, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258036/Drink/list%20image/B%C3%B2%20C%E1%BB%A4ng/picture2.jpg', 5)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (17, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258036/Drink/list%20image/B%C3%B2%20C%E1%BB%A4ng/picture3.jpg', 5)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (18, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258036/Drink/list%20image/B%C3%B2%20C%E1%BB%A4ng/picture1.jpg', 6)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (19, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258036/Drink/list%20image/B%C3%B2%20C%E1%BB%A4ng/picture2.jpg', 6)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (20, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258036/Drink/list%20image/B%C3%B2%20C%E1%BB%A4ng/picture3.jpg', 6)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (21, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258263/Drink/list%20image/Pepsi1.25/picture1.jpg', 7)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (22, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258263/Drink/list%20image/Pepsi1.25/picture2.jpg', 7)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (23, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258263/Drink/list%20image/Pepsi1.25/picture1.jpg', 8)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (24, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258263/Drink/list%20image/Pepsi1.25/picture2.jpg', 8)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (25, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258425/Drink/list%20image/Sting%20d%C3%A2u/picture1.jpg', 9)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (26, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258425/Drink/list%20image/Sting%20d%C3%A2u/picture2.jpg', 9)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (27, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258425/Drink/list%20image/Sting%20d%C3%A2u/picture3.jpg', 9)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (28, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258425/Drink/list%20image/Sting%20d%C3%A2u/picture1.jpg', 10)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (29, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258425/Drink/list%20image/Sting%20d%C3%A2u/picture2.jpg', 10)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (30, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258425/Drink/list%20image/Sting%20d%C3%A2u/picture3.jpg', 10)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (31, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258755/canned/list%20image/B%C3%B2%20h%E1%BA%A7m%20Vissan/picture1.jpg', 11)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (32, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258755/canned/list%20image/B%C3%B2%20h%E1%BA%A7m%20Vissan/picture2.jpg', 11)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (33, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258755/canned/list%20image/B%C3%B2%20h%E1%BA%A7m%20Vissan/picture3.jpg', 11)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (34, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258755/canned/list%20image/B%C3%B2%20h%E1%BA%A7m%20Vissan/picture1.jpg', 12)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (35, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258755/canned/list%20image/B%C3%B2%20h%E1%BA%A7m%20Vissan/picture2.jpg', 12)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (36, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258755/canned/list%20image/B%C3%B2%20h%E1%BA%A7m%20Vissan/picture3.jpg', 12)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (37, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258962/canned/list%20image/Th%E1%BB%8Bt%20heo%20hormel/picture1.jpg', 13)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (38, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258962/canned/list%20image/Th%E1%BB%8Bt%20heo%20hormel/picture1.jpg', 13)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (39, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258962/canned/list%20image/Th%E1%BB%8Bt%20heo%20hormel/picture1.jpg', 14)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (40, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561258962/canned/list%20image/Th%E1%BB%8Bt%20heo%20hormel/picture1.jpg', 14)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (41, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260616/canned/list%20image/C%C3%A1%20h%E1%BB%99p%203%20c%C3%B4%20g%C3%A1i/picture1.jpg', 15)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (42, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260616/canned/list%20image/C%C3%A1%20h%E1%BB%99p%203%20c%C3%B4%20g%C3%A1i/picture2.jpg', 15)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (43, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260616/canned/list%20image/C%C3%A1%20h%E1%BB%99p%203%20c%C3%B4%20g%C3%A1i/picture1.jpg', 16)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (44, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260616/canned/list%20image/C%C3%A1%20h%E1%BB%99p%203%20c%C3%B4%20g%C3%A1i/picture2.jpg', 16)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (45, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260866/spice/list%20image/T%C6%B0%C6%A1ng%20%E1%BB%9Bt%20Chinsu/picture1.jpg', 17)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (46, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260866/spice/list%20image/T%C6%B0%C6%A1ng%20%E1%BB%9Bt%20Chinsu/picture2.jpg', 17)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (47, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260866/spice/list%20image/T%C6%B0%C6%A1ng%20%E1%BB%9Bt%20Chinsu/picture1.jpg', 18)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (48, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561260866/spice/list%20image/T%C6%B0%C6%A1ng%20%E1%BB%9Bt%20Chinsu/picture2.jpg', 18)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (49, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261075/spice/list%20image/%20H%E1%BA%A1t%20N%C3%AAm%20CHIN-SU%20800g/picture1.jpg', 19)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (50, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261075/spice/list%20image/%20H%E1%BA%A1t%20N%C3%AAm%20CHIN-SU%20800g/picture2.jpg', 19)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (51, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261436/spice/list%20image/%20H%E1%BA%A1t%20N%C3%AAm%20CHIN-SU%20400g/picture1.jpg', 20)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (52, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261436/spice/list%20image/%20H%E1%BA%A1t%20N%C3%AAm%20CHIN-SU%20400g/picture2.jpg', 20)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (53, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261812/spice/list%20image/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c%20500ml/picture1.jpg', 21)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (54, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261812/spice/list%20image/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c%20500ml/picture2.jpg', 21)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (55, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261812/spice/list%20image/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c%20500ml/picture3.jpg', 21)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (56, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261812/spice/list%20image/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c%20500ml/picture1.jpg', 22)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (57, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261812/spice/list%20image/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c%20500ml/picture2.jpg', 22)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (58, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561261812/spice/list%20image/N%C6%B0%E1%BB%9Bc%20m%E1%BA%AFm%20Nam%20Ng%C6%B0%20Ph%C3%BA%20Qu%E1%BB%91c%20500ml/picture3.jpg', 22)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (59, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262426/fruitandvegetables/list%20image/G%E1%BA%A1o%20S%E1%BA%A1ch%20L%C3%A0ng%20Ta%20Vua%20G%E1%BA%A1o%205kg/picture1.jpg', 23)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (60, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262426/fruitandvegetables/list%20image/G%E1%BA%A1o%20S%E1%BA%A1ch%20L%C3%A0ng%20Ta%20Vua%20G%E1%BA%A1o%205kg/picture2.jpg', 23)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (61, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262426/fruitandvegetables/list%20image/G%E1%BA%A1o%20S%E1%BA%A1ch%20L%C3%A0ng%20Ta%20Vua%20G%E1%BA%A1o%205kg/picture1.jpg', 24)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (62, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262426/fruitandvegetables/list%20image/G%E1%BA%A1o%20S%E1%BA%A1ch%20L%C3%A0ng%20Ta%20Vua%20G%E1%BA%A1o%205kg/picture2.jpg', 24)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (63, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262947/canned/list%20image/C%C3%81%20CAPELIN%20500G/picture1.jpg', 25)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (64, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262947/canned/list%20image/C%C3%81%20CAPELIN%20500G/picture2.jpg', 25)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (65, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262947/canned/list%20image/C%C3%81%20CAPELIN%20500G/picture1.jpg', 26)
INSERT [dbo].[StoreProductImage] ([FSPId], [ImageSrc], [StoreProductId]) VALUES (66, N'https://res.cloudinary.com/dr4hpc9gi/image/upload/v1561262947/canned/list%20image/C%C3%81%20CAPELIN%20500G/picture2.jpg', 26)
SET IDENTITY_INSERT [dbo].[StoreProductImage] OFF
SET IDENTITY_INSERT [dbo].[Ward] ON 

INSERT [dbo].[Ward] ([WardId], [WardName], [CityId]) VALUES (1, N'Tân Bình', 1)
INSERT [dbo].[Ward] ([WardId], [WardName], [CityId]) VALUES (2, N'Hóc Môn', 1)
SET IDENTITY_INSERT [dbo].[Ward] OFF
ALTER TABLE [dbo].[City]  WITH CHECK ADD  CONSTRAINT [FKCity890254] FOREIGN KEY([CountryId])
REFERENCES [dbo].[Country] ([CountryId])
GO
ALTER TABLE [dbo].[City] CHECK CONSTRAINT [FKCity890254]
GO
ALTER TABLE [dbo].[Customer]  WITH CHECK ADD  CONSTRAINT [FKCustomer31235] FOREIGN KEY([AccountId])
REFERENCES [dbo].[Account] ([AccountId])
GO
ALTER TABLE [dbo].[Customer] CHECK CONSTRAINT [FKCustomer31235]
GO
ALTER TABLE [dbo].[District]  WITH CHECK ADD  CONSTRAINT [FKDistrict_Ward] FOREIGN KEY([WardId])
REFERENCES [dbo].[Ward] ([WardId])
GO
ALTER TABLE [dbo].[District] CHECK CONSTRAINT [FKDistrict_Ward]
GO
ALTER TABLE [dbo].[FlashSaleProduct]  WITH CHECK ADD  CONSTRAINT [FKFlashSaleP710042] FOREIGN KEY([StoreProductId])
REFERENCES [dbo].[StoreProduct] ([StoreProductId])
GO
ALTER TABLE [dbo].[FlashSaleProduct] CHECK CONSTRAINT [FKFlashSaleP710042]
GO
ALTER TABLE [dbo].[FlashSaleProduct]  WITH CHECK ADD  CONSTRAINT [FKFlashSaleP913089] FOREIGN KEY([FlashSalesId])
REFERENCES [dbo].[FlashSales] ([FlashSalesId])
GO
ALTER TABLE [dbo].[FlashSaleProduct] CHECK CONSTRAINT [FKFlashSaleP913089]
GO
ALTER TABLE [dbo].[FlashSales]  WITH CHECK ADD  CONSTRAINT [FKFlashSales52737] FOREIGN KEY([StoreId])
REFERENCES [dbo].[Store] ([StoreId])
GO
ALTER TABLE [dbo].[FlashSales] CHECK CONSTRAINT [FKFlashSales52737]
GO
ALTER TABLE [dbo].[Like]  WITH CHECK ADD  CONSTRAINT [FKLike617475] FOREIGN KEY([StoreProductId])
REFERENCES [dbo].[StoreProduct] ([StoreProductId])
GO
ALTER TABLE [dbo].[Like] CHECK CONSTRAINT [FKLike617475]
GO
ALTER TABLE [dbo].[Like]  WITH CHECK ADD  CONSTRAINT [FKLike749760] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([CustomerId])
GO
ALTER TABLE [dbo].[Like] CHECK CONSTRAINT [FKLike749760]
GO
ALTER TABLE [dbo].[Location]  WITH CHECK ADD  CONSTRAINT [FKLocation635873] FOREIGN KEY([DistrictId])
REFERENCES [dbo].[District] ([DistrictId])
GO
ALTER TABLE [dbo].[Location] CHECK CONSTRAINT [FKLocation635873]
GO
ALTER TABLE [dbo].[Order]  WITH CHECK ADD  CONSTRAINT [FKOrder760743] FOREIGN KEY([CustomerCustomerId])
REFERENCES [dbo].[Customer] ([CustomerId])
GO
ALTER TABLE [dbo].[Order] CHECK CONSTRAINT [FKOrder760743]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FKOrderDetai419373] FOREIGN KEY([FlashSaleProductId])
REFERENCES [dbo].[FlashSaleProduct] ([FlashSaleProductId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FKOrderDetai419373]
GO
ALTER TABLE [dbo].[OrderDetail]  WITH CHECK ADD  CONSTRAINT [FKOrderDetai519281] FOREIGN KEY([OrderOrderId])
REFERENCES [dbo].[Order] ([OrderId])
GO
ALTER TABLE [dbo].[OrderDetail] CHECK CONSTRAINT [FKOrderDetai519281]
GO
ALTER TABLE [dbo].[Product]  WITH CHECK ADD  CONSTRAINT [FKProduct782935] FOREIGN KEY([CategoriesId])
REFERENCES [dbo].[Categories] ([CategoriesId])
GO
ALTER TABLE [dbo].[Product] CHECK CONSTRAINT [FKProduct782935]
GO
ALTER TABLE [dbo].[Store]  WITH CHECK ADD  CONSTRAINT [FKStore510068] FOREIGN KEY([StoreManagerId])
REFERENCES [dbo].[StoreManager] ([StoreManagerId])
GO
ALTER TABLE [dbo].[Store] CHECK CONSTRAINT [FKStore510068]
GO
ALTER TABLE [dbo].[Store]  WITH CHECK ADD  CONSTRAINT [FKStore575172] FOREIGN KEY([LocationId])
REFERENCES [dbo].[Location] ([LocationId])
GO
ALTER TABLE [dbo].[Store] CHECK CONSTRAINT [FKStore575172]
GO
ALTER TABLE [dbo].[StoreFollwer]  WITH CHECK ADD  CONSTRAINT [FKStoreFollw289234] FOREIGN KEY([StoreId])
REFERENCES [dbo].[Store] ([StoreId])
GO
ALTER TABLE [dbo].[StoreFollwer] CHECK CONSTRAINT [FKStoreFollw289234]
GO
ALTER TABLE [dbo].[StoreFollwer]  WITH CHECK ADD  CONSTRAINT [FKStoreFollw688327] FOREIGN KEY([CustomerId])
REFERENCES [dbo].[Customer] ([CustomerId])
GO
ALTER TABLE [dbo].[StoreFollwer] CHECK CONSTRAINT [FKStoreFollw688327]
GO
ALTER TABLE [dbo].[StoreManager]  WITH CHECK ADD  CONSTRAINT [FKStoreManag197504] FOREIGN KEY([AccountId])
REFERENCES [dbo].[Account] ([AccountId])
GO
ALTER TABLE [dbo].[StoreManager] CHECK CONSTRAINT [FKStoreManag197504]
GO
ALTER TABLE [dbo].[StoreProduct]  WITH CHECK ADD  CONSTRAINT [FKStoreProdu687230] FOREIGN KEY([ProductId])
REFERENCES [dbo].[Product] ([ProductId])
GO
ALTER TABLE [dbo].[StoreProduct] CHECK CONSTRAINT [FKStoreProdu687230]
GO
ALTER TABLE [dbo].[StoreProduct]  WITH CHECK ADD  CONSTRAINT [FKStoreProdu809531] FOREIGN KEY([StoreId])
REFERENCES [dbo].[Store] ([StoreId])
GO
ALTER TABLE [dbo].[StoreProduct] CHECK CONSTRAINT [FKStoreProdu809531]
GO
ALTER TABLE [dbo].[StoreProductImage]  WITH CHECK ADD  CONSTRAINT [FKFlashSaleP924316] FOREIGN KEY([StoreProductId])
REFERENCES [dbo].[StoreProduct] ([StoreProductId])
GO
ALTER TABLE [dbo].[StoreProductImage] CHECK CONSTRAINT [FKFlashSaleP924316]
GO
ALTER TABLE [dbo].[Ward]  WITH CHECK ADD  CONSTRAINT [FKWard783817] FOREIGN KEY([CityId])
REFERENCES [dbo].[City] ([CityId])
GO
ALTER TABLE [dbo].[Ward] CHECK CONSTRAINT [FKWard783817]
GO
