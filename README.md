
# Cleaner Supply automation test using Katalon
![Katalon logo](https://testautomationresources.com/wp-content/uploads/2020/08/Katalon-Studio.png)

## Team member
1. Razan Hammad
2. Shimaa Iqtefan
3. Waleed A. Afifi

## Requirenments
- Windows 7 or higher
- macOS 10.11 or later
- Linux with OpenJDK 8.0 [Tutorial](https://docs.katalon.com/katalon-studio/docs/katalon-studio-gui-beta-for-linux.html#install-katalon-studio-for-linux)
- Minimum 2GHz CPU
- 2GB of ram minimum

---

<img src="https://apptest.ai/wp-content/uploads/2019/08/ai_testbot_v2.1ca83181.gif" alt="testing image" width="500"/>

## Getting started

### Using Terminal
1. Using terminal clone the project using git
```Java
git clone https://github.com/QA-Gateway-Training/cleanersupply.git
```
2. Open the project File -> Open Project
---
### Using Katalon
1. Create a new project
2. Using the git icon click on share project, Katalon will ask you. for you git information
   
<img src="https://forum.katalon.com/uploads/default/original/3X/3/e/3ecec66acdddb0b074641bc4845da31150c31ddd.png" alt="testing image" width="100"/>

3. Once it finish click again on git icon from the toolbar and click on clone project
4. copy GitHub repo. link
```Java
https://github.com/QA-Gateway-Training/cleanersupply.git
```
5. Using the window, past the link into `Location`
6. Fill your github username and password, and check save auth
  

---
## Test Scenarios <img src="https://cdn.dribbble.com/users/260783/screenshots/5792528/samsung_icons_adam_fard_s.gif" alt="testing image" width="30"/>


  1. Product Details Scenario.
  2. Category Scenario.
  3. Quick Order Scenario.
  
## Test Steps
  1. Step 1
  2. Step 2

## Test Plan

1- Header test plan
  - test 1

2- Product details page test plan ( search )
  - Verify page url
  - Verify page Title ( title cappetlize but the product name uppercase <img src="https://c.tenor.com/IUzym1Pr2x0AAAAC/bug-cute.gif" alt="testing image" width="30"/>)
  - Verify product name contain part of the name
  - Verify breadcrumb
  - Verify `sku` number with the url
  - Verify the `price` between the range of teh price
  - Verify available color to be equal colors of the product
  - Verify the name checnges once `Color` and `Size` changed
  - Verify `hover` effect for add to cart button
  - Verify `hover` effect for the size button
  - Verify quantity value by enter value and check if refelected
  - Verify `Added to Cart` on click add to cart button
  - Verify MiniCart if the product reflected after adding
  - Verify if the price with the quantity reflected in the volume table
  - Verify product spec. size changing

3- Search result page test plan
  - Verify current page title
  - Verify current page url
  - Verify heading tag
  - Verify product section headding tag contains `searchTerm` keyword and static number 224
  - Verify the filter default
    - None of the filter checked
    - Selected filters section not visible
    - Sort by featured
    - Color card is collapsed
  - Verify on select filter page loading overlay
  - Verify `selected` class once the filter selected
  - Verify the filter add to the selected filter section
  - Verify the data has been changed on change the filter ( product counter not correct `Bug` <img src="https://c.tenor.com/IUzym1Pr2x0AAAAC/bug-cute.gif" alt="testing image" width="30"/>)
  - Verify the pagination is displayed
  - Verify the current page is checked in the pagination
  
4- Checkout Test Plan
  - init Page
    - Verify checkout as a guest checked and contain the correct text
    - Verify hover effect for continue button
    - Verify summary table contain the added items
    - Verify price total in the title and the summary
    - Verify url, title, heading
  - Form page
    - Verify summary table contain the added items
    - Verify price total in the title and the summary
    - Verify url, title, heading
    - Verify checkout form fileds one by one 
      - Values
      - style ( focus style, shadow, border)
    - Verify state value
    - Verify shipping fees ( expand the card of shipping and check for the readio selected)
    - Verify payment method form
  - Information page
    - Verify summary table contain the added items
    - Verify price total in the title and the summary
    - Verify url, title, heading
    - Verify displayed information are the same as user entered

5- Quick order test plan
  - test 1
  
6- Search
  - Check placeholder
  - Fill the field and check if reflected
  - Check the top bar contains search term
  - Check top bar background
  - Click on search button
 
7- All Pages Default Footer Test Plan
  - Verify existing Of Top Footer.
  - Verify existing of Image in Top Footer.
  - Verify background Color of top footer (yellow Color).
  - Verify max height of top footer as expected.
  - Verify existing of footer body and has a black Background Color.
  - Verify Right Column' content in footer body.
  - Verify request catalog link and icon with wight color and validate click's redirection.
  - Verify free classifieds link and icon with wight color and validate click's redirection.
  - Verify existing of choose region span.
  - Verify USA as default region.
  - Verify region's button can be clickable and by default has an aria expanded attribute equal to false.
  - Verify visibility of a region's list when click on region's button.
  - Verify visibility of leave feedback button, verify clicking it and a pop- up modal appear.
  - Verify Filling feedback's modal with a comment and email and close it.( note: Katalon can't support recaptcha verification image).
  - Verify existing of bbb logo image at the end left column in footer's body.
  -   
  - 
  
8- Shopping Cart
  - Verify Page url
  - Verify page title
  - Verify Heading tag
  - Verify the table contain data
  - Verify the items informations based on what added to cart from product page
  - Verify the totals ( productTotal, summary total, sub total )
  - Veryfi checkout button style, then click
  
   
## Update <img src="https://static.wixstatic.com/media/c25f40_b40fd52500d9473aa2a6d93115091847~mv2.gif" alt="testing image" width="40"/>
- [x] Checkout summary table check with the added product to the cart
- [x] Check product price with the volume table depend on the quantity

## Todo <img src="https://i.pinimg.com/originals/89/d9/e0/89d9e0f67c361865fe9746c3c3de6b8a.gif" alt="testing image" width="50"/>
- [ ] Verify `header` assertions for all pages and the `header` for the checkout page
- [ ] Verify `footer` assertions for all pages and the `footer` for the checkout page
