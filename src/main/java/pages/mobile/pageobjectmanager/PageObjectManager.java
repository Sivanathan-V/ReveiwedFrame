package pages.mobile.pageobjectmanager;


import pages.mobile.*;


public class PageObjectManager extends Mobile_BasePage {

    private HomePage homePage;
    private ProductList productList;
    private ProductPage productPage;
    private CartPage cartPage;
    public HomePage getHomePage() {
        return (homePage==null)?homePage= new HomePage():homePage;
    }
    public ProductList getProductList() {
        return (productList==null)?productList=new ProductList():productList;
    }
    public ProductPage getProductPage() {
        return (productPage==null)?productPage=new ProductPage():productPage;
    }
    public CartPage getCartPage() {
        return (cartPage==null)?cartPage=new CartPage():cartPage;
    }




}
