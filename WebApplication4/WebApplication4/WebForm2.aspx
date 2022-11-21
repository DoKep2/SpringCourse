<%@ Page Language="C#" AutoEventWireup="true" CodeBehind="WebForm2.aspx.cs" Inherits="WebApplication4.WebForm2" %>

<!DOCTYPE html>
<%@ Import Namespace="System.IO" %>
<%@ Import Namespace="System.Net" %>
<%@ Import Namespace="System.Xml" %>
<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
  
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="style/style2.css" />
    <link rel="stylesheet" href="style/normalize.css" />
     <title>Energy Balance Calculator</title>
  </head>
 <body onload="return window_onload()">
       
    <div class="container">
      <div class="rounded-container1">
        <p class="text-container1">Energy Balance Calculator</p>
        <p class="text-container2">Estimated energy balance for 24 hours</p>
      </div>
      <div class="rounded-container2">
        <p class="text-container3">
          Estimated energy balance for<br/>
            <%
                DateTime day = DateTime.Today.AddDays(1);
                string selection = Request.Form["timslots"];
                int selHour = Convert.ToInt32(selection.Substring(0, 2));

                if (selection == null)
                {
                    selection = "";
                }

                if (selHour < day.Hour)
                {
                    day = day.AddDays(1);
                }
                string date = day.ToString("dd.MM.yyyy");
                Response.Write(date + ", " + Request.Form["timslots"] + " is");

                        %>
        </p>
        <div class="rounded-container4">
            <%
                StringWriter writer = new StringWriter();
                WebRequest myRequest = WebRequest.Create(@"https://api.fingrid.fi/v1/variable/241/events/xml?start_time=2022-11-21T00%3A00%3A00Z&end_time=2022-11-22T23%3A59%3A00Z");
                string usernamePassword = "kflzSoUEdF5zhRJRjs5Ch4mNBXUmsUSP21b78kBW";
                myRequest.Headers.Add("x-api-key", usernamePassword);
                WebResponse response = myRequest.GetResponse();
                // Get the stream containing content returned by the server.

                Stream dataStream = response.GetResponseStream();
                // Open the stream using a StreamReader for easy access.
                StreamReader reader = new StreamReader(dataStream);
                // Read the content.
                string responseFromServer = reader.ReadToEnd();
                string production = "";
                XmlReader myXmlReader = XmlReader.Create(new StringReader(responseFromServer));
                if (myXmlReader.ReadToFollowing("value"))
                {
                    production = myXmlReader.ReadElementContentAsString();
                }
                
                myRequest = WebRequest.Create(@"https://api.fingrid.fi/v1/variable/166/events/xml?start_time=2022-11-21T00%3A00%3A00Z&end_time=2022-11-22T23%3A59%3A00Z");
                response = myRequest.GetResponse();
                // Get the stream containing content returned by the server.

                myRequest.Headers.Add("x-api-key", usernamePassword);
                dataStream = response.GetResponseStream();
                // Open the stream using a StreamReader for easy access.
                reader = new StreamReader(dataStream);
                // Read the content.
                responseFromServer = reader.ReadToEnd();
                myXmlReader = XmlReader.Create(new StringReader(responseFromServer));
         

          
                

                %>
          <p class="text-container5"><% Response.Write(energyBalance+"%"); %></p>
          <p class="text-container6">It is a good time to use energy</p>
          <p class="text-container7">Production: <%Response.Write(consumption); %>,demand:<%Response.Write(production); %></p>
        </div>
      </div>
      <div class="rounded-container3">
        <p class="text-container4">Hour</p>
      </div>
      <div>
           <form id="WebForm2" runat="server" name="Get Data" method="post" action="WebForm1.aspx">
        <div style="width: 566px; height: 19px">
<select id="text">
    
                                       <%
                                    for (int i = DateTime.Now.Hour; i < 24; i++)
                                    {
                                        if (i < 10)
                                        {
                                            Response.Write("<option value=" + i + ">"+ "0" + i + ":00" + "</option>");
                                        }
                                        else 
                                            Response.Write("<option value=" + i + ">" + i + ":00" + "</option>");
                                    }
                                    for (int i = 0; i < DateTime.Now.Hour; i++)
                                    {
                                        if (i < 10)
                                        {
                                            Response.Write("<option value=" + i + ">"+ "0" + i + ":00" + "</option>");
                                        }
                                        else 
                                            Response.Write("<option value=" + i + ">" + i + ":00" + "</option>");
                                    }
                            %>
</select>
    </div>

                                 <button id="button" value="Get Data">Get Data</button>
        </form>
      </div>
    </div>
  </body>
</html>
