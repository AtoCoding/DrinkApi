create database DrinkStore;
go

use DrinkStore;
go

create table Brand(
	BrandId int primary key identity,
	BrandName nvarchar(100) NOT NULL,
);

create table Category(
	CategoryId int primary key identity,
	CategoryName nvarchar(100) NOT NULL,
);

create table Drink(
	DrinkId int primary key identity,
	DrinkName nvarchar(100) NOT NULL,
	Quantity int NOT NULL,
	BrandId int NOT NULL,
	CategoryId int NOT NULL,

	constraint FK_BRANDID foreign key(BrandId) references Brand(BrandId),
	constraint FK_CATEGORYID foreign key(CategoryId) references Category(CategoryId),
);

create table Size(
	SizeId int primary key identity,
	SizeType nvarchar(10) NOT NULL,
);

create table DrinkSize(
	DrinkId int,
	SizeId int,
	UnitPrice decimal(9, 2),

	constraint PK_DRINKSIZE primary key(DrinkId, SizeId),
	constraint FK_DRINKID foreign key(DrinkId) references Drink(DrinkId),
	constraint FK_SIZEID foreign key(SizeId) references Size(SizeId),
);

go

insert into Size(SizeType) values (N'Nhỏ'), (N'Trung'), (N'Đại');
insert into Category(CategoryName) values (N'Nước ngọt'), (N'Soda');
insert into Brand(BrandName) values (N'PepsiCo'), (N'The Coca-Cola Company'), (N'SFC');
insert into Drink(DrinkName, Quantity, BrandId, CategoryId) values 
(N'Sting đỏ', 34, 1, 1),
(N'Sting vàng', 50, 1, 1),
(N'Cocacola', 12, 2, 1),
(N'Soda dưa hấu', 0, 3, 2),
(N'Soda dưa lưới', 250, 3, 2);
insert into DrinkSize(DrinkId, SizeId, UnitPrice) values 
(1, 2, 10000),
(2, 2, 10000),
(3, 1, 9000),
(3, 2, 11000),
(3, 3, 18000),
(4, 2, 25000),
(5, 2, 26000);

select Drink.DrinkId, Brand.BrandName, Drink.DrinkName, DrinkSize.UnitPrice, Size.SizeType
from Drink
join Brand on Drink.BrandId = Brand.BrandId
join DrinkSize on Drink.DrinkId = DrinkSize.DrinkId
join Size on DrinkSize.SizeId = Size.SizeId;

select Drink.DrinkId, Drink.DrinkName, Drink.Quantity, Brand.BrandName, Category.CategoryName, DrinkSize.UnitPrice, Size.SizeId, Size.SizeType
from Drink
join Brand on Drink.BrandId = Brand.BrandId
join Category on Drink.CategoryId = Category.CategoryId
join DrinkSize on Drink.DrinkId = DrinkSize.DrinkId AND Drink.DrinkId = 4
join Size on DrinkSize.SizeId = Size.SizeId AND Size.SizeId = 2; 
