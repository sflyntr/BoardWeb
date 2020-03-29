# BoardWeb

# Directory Structure

.  
├── BoardWeb.iml  
├── README.md  
├── pom.xml  
└── src  
    ├── main  
    │   ├── java  
    │   ├── resources   
    │   └── webapp  
    │       ├── WEB-INF  
    │       │   └── web.xml  
    │       └── index.jsp  
    └── test  
        ├── java  
        └── resources  

# Model 1 아키텍쳐
### 화면은 모두 jsp로 구성하고, jsp내에 <% %> tag를 이용하여 java logic을 넣은 아키텍쳐

# Model 2 아키텍쳐
### 모든 jsp는 화면구성만 있고 별도로 DispatcherServlet을 작성하여 로직을 모두 넣음.
### 그 DispatchServlet은 HttpServlet을 상속받아야 하며, HttpServletRequest, HttpServletResponse를 Paramter로 받아야 한다.
### 그리고, doGet, doPost를 구현해야 한다. 또는 service 를 직접 구현해도 된다.
### jsp내에 모든 java로직을 DispatcherServlet으로 분리하였으니, 그 jsp와 DispatchServlet간의 데이터통신은 session.setAttribute로 해야 한다.


