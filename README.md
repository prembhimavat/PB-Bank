# PB-Bank
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#contact">Contact</a></li>
  </ol>
</details>



<!-- ABOUT THE PROJECT -->
## About The Project

PB-Bank is a web application built with Spring Mvc. This project is implemented using HttpSession i.e. multiple users can access the website at the same time. Users can create account, edit account and send money to each other.


<p align="right">(<a href="#top">back to top</a>)</p>

### Built With

* Html
* Css
* Jsp
* Spring Context
* Spring Web Mvc
* Spring Jdbc
* My Sql
<p align="right">(<a href="#top">back to top</a>)</p>


<!-- GETTING STARTED -->
## Getting Started

To run this project on your local server you'll need -

### Prerequisites

* My Sql
* Apache Tomcat Server
* An Ide of your choice


### Installation

(In Eclipse)
1. Create a dynamic web project and configure it into a Maven Project
2. Make sure you have added Apache tomcat server
3. Copy pom.xml file and install all the dependencies
4. Copy the Source code
5. Go to Mysql and create 3 databases -
   <ol>
     <li>bankCustomer</li>
     <li>bankAccount</li>
     <li>bankTransaction</li>
   </ol>
6. Create table in these databases and create columns by referring to the fields from modal controller respectively (make sure you update sql queries in dao)

<p align="right">(<a href="#top">back to top</a>)</p>



<!-- USAGE EXAMPLES -->
## Usage

<img src="/images/bankHome.jpg" alt="Home Page">
<img src="/images/bankDashboard.jpg" alt="Dashboard">
<img src="/images/bankAccounts.jpg" alt="All Accounts">
<img src="/images/bankSendMoney.jpg" alt="Send Money">
<img src="/images/bankAllTransactions.jpg" alt="All Transactions">


<p align="right">(<a href="#top">back to top</a>)</p>


<!-- CONTACT -->
## Contact

Twitter - [@prembhimavat](https://twitter.com/prembhimavat)

<p align="right">(<a href="#top">back to top</a>)</p>
