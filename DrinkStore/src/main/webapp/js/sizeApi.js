async function getSizeList() {
    const apiUrl = "/DrinkStore/v1/size/";
    try {
        const response = await axios.get(apiUrl);
        return response;
    } catch(error) {
        alert(error);
        console.log(error);
    }
}