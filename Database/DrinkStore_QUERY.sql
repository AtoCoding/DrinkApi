select Drink.DrinkId, Brand.BrandName, Drink.DrinkName, DrinkSize.UnitPrice, Size.SizeType
from Drink
join Brand on Drink.BrandId = Brand.BrandId
join DrinkSize on Drink.DrinkId = DrinkSize.DrinkId
join Size on DrinkSize.SizeId = Size.SizeId;

select Drink.DrinkId, Drink.DrinkName, DrinkSize.Quantity, Brand.BrandName, Category.CategoryName, DrinkSize.UnitPrice, Size.SizeId, Size.SizeType
from Drink
join Brand on Drink.BrandId = Brand.BrandId
join Category on Drink.CategoryId = Category.CategoryId
join DrinkSize on Drink.DrinkId = DrinkSize.DrinkId AND Drink.DrinkId = 4
join Size on DrinkSize.SizeId = Size.SizeId AND Size.SizeId = 2; 

select * from Drink;
select * from DrinkSize;

alter table Drink 
drop column Quantity;

alter table DrinkSize 
add Quantity int;

update DrinkSize set Quantity = 34 where DrinkId = 1 AND SizeId = 2;
update DrinkSize set Quantity = 50 where DrinkId = 2 AND SizeId = 2;
update DrinkSize set Quantity = 12 where DrinkId = 3 AND SizeId = 1;
update DrinkSize set Quantity = 0 where DrinkId = 3 AND SizeId = 2;
update DrinkSize set Quantity = 23 where DrinkId = 3 AND SizeId = 3;
update DrinkSize set Quantity = 0 where DrinkId = 4 AND SizeId = 2;
update DrinkSize set Quantity = 250 where DrinkId = 5 AND SizeId = 2;

