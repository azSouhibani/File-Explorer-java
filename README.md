# File-Explorer-java
<h1> The purpose of this program is to explore files and display them in a GUI format.</h1>

<h3> How to run the program ? </h3>
<ul>
  <li>It starts from the App.java</li>
  <li>in App.java put the desired directory in your machine</li>
  <li>Then simply run the program :)</li>
</ul>

<h3> How the program works ? </h3>
<ul>
  <li>it uses Composite Design Pattern, where >>
    <ul>
      <li>EDoc Abstract Class represents the Composite interface</li>
      <li>Folder Class represents the Component</li>
      <li>File Class Represents the Leaf</li>
    </ul>
  </li>
  <li>App class is just for the GUI and the program runs from there</li>
  <li> it starts by discovering the subdirectories inside the given directory, and creating objects (Folder or File)</li>
  
</ul>
