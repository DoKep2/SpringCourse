<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm1.aspx.cs" Inherits="WebApplication4.WebForm1" %>

<!DOCTYPE html>
<%@ Import Namespace="System.IO"%>
<%@ Import Namespace="System.Net"%>
<%@ Import Namespace="System.Xml"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
    <link rel="stylesheet" href="style/style.css" />
    <link rel="stylesheet" href="style/normalize.css" />
    <title>Energy Balance Calculator</title>
</head>
<body onload="return window_onload()">
<div class="container"/>
      <div class="rounded-container1">
        <p class="text-container1">Energy Balance Calculator</p>
        <p class="text-container2">Estimated energy balance for 24 hours</p>
      </div>
      <div class="rounded-container2">
        <p class="text-container3">Estimation</p>
          <div class="rounded-container4">
          <p class="text-container5"></p>
          <p class="text-container6">
            
          </p>
          <p class="text-container7">Production: demand:</p>
        </div> 
      </div>
      <div class="rounded-container3">
        <label for="timslots" class="text-container4">Hour</label>
         
           </div>
    <form id="WebForm1" runat="server" name="Get Data" method="post" action="WebForm2.aspx">
        <div style="width: 566px; height: 19px">
            <label for="timslots"></label>
<select name="timslots" id="text">
    
                                        
                            <%
                                    for (int i = DateTime.Now.Hour; i < 24; i++)
                                    {
                                        if (i < 10)
                                        {
                                            Response.Write("<option selected=\"selected\">0" + i + ":00" + "</option>");
                                        }
                                        else 
                                            Response.Write("<option selected=\"selected\">"  + i + ":00" + "</option>");
                                    }
                                    for (int i = 0; i < DateTime.Now.Hour; i++)
                                    {
                                        if (i < 10)
                                        {
                                            Response.Write("<option selected=\"selected\">0"  + i + ":00" + "</option>");
                                        }
                                        else 
                                            Response.Write("<option selected=\"selected\">"  + i + ":00" + "</option>");
                                    }
                            %>
</select>
    </div>

                                 <button id="button" value="Get Data">Get Data</button>
                                  
                                    
                            </form>

    </body>
    </html>