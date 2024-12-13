async function getBrandList() {
    const apiUrl = "/DrinkStore/v1/brand/";
    try {
        const response = await axios.get(apiUrl);
        return response;
    } catch(error) {
        alert(error);
        console.log(error);
    }
}


