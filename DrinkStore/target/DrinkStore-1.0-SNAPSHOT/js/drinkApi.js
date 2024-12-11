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
    console.log("Loading");
    try {
        console.log("Loading");
        const response = await axios.get(apiUrl);
        console.log(response);
        
        const cellDrinkId = document.getElementById("drink-id");
        cellDrinkId.textContent = response.data.data.drinkId;
        
        const cellDrinkName = document.getElementById("drink-name");
        cellDrinkName.textContent = response.data.data.drinkName;
        
        const cellQuantity = document.getElementById("quantity");
        cellQuantity.textContent = response.data.data.quantity;
        
        const cellBrandName = document.getElementById("brand-name");
        cellBrandName.textContent = response.data.data.brandName;
        
        const cellCategoryName = document.getElementById("category-name");
        cellCategoryName.textContent = response.data.data.categoryName;
        
        const cellUnitPrice = document.getElementById("unit-price");
        cellUnitPrice.textContent = response.data.data.unitPrice;
        
        const cellSizeId = document.getElementById("size-id");
        cellSizeId.textContent = response.data.data.sizeId;
        
        const cellSizeType = document.getElementById("size-type");
        cellSizeType.textContent = response.data.data.sizeType;
        
    } catch (error) {
        alert(error);
    }
}


