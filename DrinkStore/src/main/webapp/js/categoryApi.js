async function getCategoryList() {
    const apiUrl = "/DrinkStore/v1/category/";
    try {
        const response = await axios.get(apiUrl);
        return response;
    } catch(error) {
        alert(error);
        console.log(error);
    }
}