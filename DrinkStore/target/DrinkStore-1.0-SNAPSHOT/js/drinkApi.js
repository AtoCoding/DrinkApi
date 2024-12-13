document.addEventListener("DOMContentLoaded", async function () {
    const currentPath = window.location.pathname; // Lấy đường dẫn hiện tại của trang
    if (currentPath.endsWith("homepage.html")) { // Kiểm tra nếu đường dẫn kết thúc bằng 'homepage.html'
        await getDrinkList();
    }

    // Lấy tham số từ URL
    const params = new URLSearchParams(window.location.search);
    const drinkId = params.get("drinkId");
    const sizeId = params.get("sizeId");

    // Kiểm tra và in tham số
    if (drinkId && sizeId) {
        console.log(`Drink ID: ${drinkId}, Size ID: ${sizeId}`);
        // Gọi API để lấy chi tiết
        await getDrinkDetails(drinkId, sizeId);
    }
});

async function getDrinkList() {
    const apiUrl = "/DrinkStore/v1/drink/";
    try {
        const response = await axios.get(apiUrl);
        console.log(response);

        const tbody = document.getElementById('bodyTable'); // Lấy phần <tbody>

        for (let i = 0; i < response.data.data.length; i++) {
            //console.log(response.data.data[i].name);

            // Tạo một dòng mới (tr)
            const row = document.createElement('tr');
            row.setAttribute("onclick", "navigateToDetailsPage(" + response.data.data[i].drinkId + ", " + response.data.data[i].sizeId + ")");

            // Tạo các ô dữ liệu (td)
            const cellBrand = document.createElement('td');
            cellBrand.textContent = response.data.data[i].brandName; // Gán giá trị ID

            const cellDrinkName = document.createElement('td');
            cellDrinkName.textContent = response.data.data[i].drinkName; // Gán giá trị Name

            const cellUnitPrice = document.createElement('td');
            cellUnitPrice.textContent = response.data.data[i].unitPrice; // Gán giá trị Author

            // Thêm các ô vào dòng
            row.appendChild(cellBrand);
            row.appendChild(cellDrinkName);
            row.appendChild(cellUnitPrice);

            // Thêm dòng vào bảng
            tbody.appendChild(row);
        }
    } catch (error) {
        console.log(error);
    }
}
;

async function navigateToDetailsPage(drinkId, sizeId) {
    window.location.assign("drink-details.html?drinkId=" + encodeURIComponent(drinkId) + "&sizeId=" + encodeURIComponent(sizeId));
}

async function getDrinkDetails(drinkId, sizeId) {
    const apiUrl = "/DrinkStore/v1/drink/details?drinkId=" + encodeURIComponent(drinkId) + "&sizeId=" + encodeURIComponent(sizeId);
    try {
        const response = await axios.get(apiUrl);
//        console.log(response);
        
        const drinkId = response.data.data.drinkId;
        const sizeId = response.data.data.sizeId;
        
        const cellDrinkId = document.getElementById("drink-id");
        cellDrinkId.textContent = drinkId;
        
        const cellDrinkName = document.getElementById("drink-name");
        cellDrinkName.value = response.data.data.drinkName;
        
        const cellQuantity = document.getElementById("quantity");
        cellQuantity.value = response.data.data.quantity;
        
        const cellBrandName = document.getElementById("brand-name");
        const optionBrandName = document.createElement("option");
        optionBrandName.value = response.data.data.brandId;
        optionBrandName.textContent = response.data.data.brandName;
        optionBrandName.setAttribute("selected", "true");
        cellBrandName.appendChild(optionBrandName);
        
        const cellCategoryName = document.getElementById("category-name");
        const optionCategoryName = document.createElement("option");
        optionCategoryName.value = response.data.data.categoryId;
        optionCategoryName.textContent = response.data.data.categoryName;
        optionCategoryName.setAttribute("selected", "true");
        cellCategoryName.appendChild(optionCategoryName);
        
        const cellUnitPrice = document.getElementById("unit-price");
        cellUnitPrice.value = response.data.data.unitPrice;
        
        const cellSizeType = document.getElementById("size-type");
        const optionSizeType = document.createElement("option");
        optionSizeType.value = response.data.data.sizeId;
        optionSizeType.textContent = response.data.data.sizeType;
        optionSizeType.setAttribute("selected", "true");
        cellSizeType.appendChild(optionSizeType);
        
        const cellUpdateButton = document.getElementById("update-button");
        cellUpdateButton.setAttribute("onclick", "modifyData('update', " + drinkId + ", " + sizeId + ")");
        
        const cellDeleteButton = document.getElementById("delete-button");
        cellDeleteButton.setAttribute("onclick", "modifyData('delete', " + drinkId + ", " + sizeId + ")");
        
    } catch (error) {
        alert(error);
        console.log(error);
    }
}

async function modifyData(action, drinkId, sizeId) {
    if(action === "update") {
        const brandApiUrl = "/DrinkStore/v1/brand/";
        const categoryApiUrl = "/DrinkStore/v1/drink/category/";
        const sizeApiUrl = "/DrinkStore/v1/drink/size/";
        
        const cellDrinkName = document.getElementById("drink-name");
        cellDrinkName.removeAttribute("disabled");
        
        const cellQuantity = document.getElementById("quantity");
        cellQuantity.removeAttribute("disabled");
        
        const cellBrandName = document.getElementById("brand-name");
        cellBrandName.removeAttribute("disabled");
        
        const cellCategoryName = document.getElementById("category-name");
        cellCategoryName.removeAttribute("disabled");
        
        const cellUnitPrice = document.getElementById("unit-price");
        cellUnitPrice.removeAttribute("disabled");
        
        const cellSizeType = document.getElementById("size-type");
        cellSizeType.removeAttribute("disabled");
        
        const txtUpdate = document.getElementById("txtUpdate");
        txtUpdate.textContent = "Confirm update";
        const btnUpdate = document.getElementById("update-button");
        btnUpdate.setAttribute("onclick", "confirmModifyData('update', " + drinkId + ", " + sizeId + ")");
        
        try {
            const brandResponse = await getBrandList();
            const categoryResponse = await getCategoryList();
            const sizeResponse = await getSizeList();
            console.log(brandResponse);
            const brandData = brandResponse.data.data;
            console.log(categoryResponse);
            const categoryData = categoryResponse.data.data;
            console.log(sizeResponse);
            const sizeData = sizeResponse.data.data;
            
            const cellBrandName = document.getElementById("brand-name");
            for(let i = 0; i < brandData.length; i++) {
                const option = document.createElement("option");
                const optionSelectedValue = cellBrandName.value;
                option.value = brandData[i].brandId;
                option.textContent = brandData[i].brandName;
                cellBrandName.appendChild(option);
            }
        } catch (error) {
            alert(error);
        }
    } else if(action === "delete") {
        
    }
}


