document.addEventListener("DOMContentLoaded", async function getDrinkList() {
    const apiUrl = "/DrinkStore/v1/drink/";
    try {
        const response = await axios.get(apiUrl);
        console.log(response);

        const tbody = document.getElementById('bodyTable'); // Lấy phần <tbody>

        for (let i = 0; i < response.data.data.length; i++) {
            //console.log(response.data.data[i].name);

            // Tạo một dòng mới (tr)
            const row = document.createElement('tr');
            row.setAttribute("onclick", "getDrinkDetails(" + response.data.data[i].drinkId + ", " + response.data.data[i].sizeId + ")");

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
});

async function getDrinkDetails(drinkId, sizeId) {
    const apiUrl = "/DrinkStore/v1/drink/details?drinkId=" + encodeURIComponent(drinkId) + "&sizeId=" + encodeURIComponent(sizeId);
    try {
        const response = await axios.get(apiUrl);
        console.log(response);

//        const tbody = document.getElementById('bodyTable'); // Lấy phần <tbody>
//
//        for (let i = 0; i < response.data.data.length; i++) {
//            //console.log(response.data.data[i].name);
//
//            // Tạo một dòng mới (tr)
//            const row = document.createElement('tr');
//            row.setAttribute("onclick", "getDrinkDetails(" + response.data.data[i].drinkId + ", " + response.data.data[i].sizeId + ")");
//
//            // Tạo các ô dữ liệu (td)
//            const cellBrand = document.createElement('td');
//            cellBrand.textContent = response.data.data[i].brandName; // Gán giá trị ID
//
//            const cellDrinkName = document.createElement('td');
//            cellDrinkName.textContent = response.data.data[i].drinkName; // Gán giá trị Name
//            
//            const cellUnitPrice = document.createElement('td');
//            cellUnitPrice.textContent = response.data.data[i].unitPrice; // Gán giá trị Author
//
//            // Thêm các ô vào dòng
//            row.appendChild(cellBrand);
//            row.appendChild(cellDrinkName);
//            row.appendChild(cellUnitPrice);
//
//            // Thêm dòng vào bảng
//            tbody.appendChild(row);
//        }
    } catch (error) {
        alert(error.response.data);
    }
}


