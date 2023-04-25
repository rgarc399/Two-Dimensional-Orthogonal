# Two-Dimensional-Orthogonal
Two-Dimensional Orthogonal Range Search Algorithm
Introduction
This project implements an algorithm for solving a two-dimensional orthogonal range search problem. The algorithm is designed to display a real-life map and enable the user to create a selection rectangle by dragging the mouse over the application window. Once a selection rectangle is issued, a window will popup containing a 5-number summary of the map elements in it.

Problem Requirements
The application displays a real-life map.
Each map element has an associated numerical value.
The user can create a selection rectangle by dragging the mouse over the application window.
A window will popup containing a 5-number summary of the map elements in it.
At least 5 map elements will be considered.
The map will be represented as an array list of rectilinear polygons.
The solution will be based on storing the vertices of the polygons in a K-2 tree data structure and running a query to determine the polygons intersected.
Implementation
The algorithm for solving the two-dimensional orthogonal range search problem is implemented as follows:

The map is represented as an array list of rectilinear polygons, with each polygon having a unique identifier and associated numerical value.

The vertices of each polygon are stored in a K-2 tree data structure, which enables efficient range search queries.

When the user creates a selection rectangle by dragging the mouse over the application window, the algorithm performs a range search query on the K-2 tree data structure.

The polygons intersected by the selection rectangle are identified, and their numerical values are used to compute a 5-number summary.

The 5-number summary is displayed in a popup window.

Testing
The algorithm for solving the two-dimensional orthogonal range search problem has been tested using various maps and selection rectangles. The results obtained from the algorithm have been validated against manual calculations, and the algorithm has been found to be accurate and efficient.

Conclusion
The two-dimensional orthogonal range search algorithm implemented in this project enables efficient computation of a 5-number summary for a selection of map elements. The use of a K-2 tree data structure ensures that the algorithm is efficient, even for large maps and complex selection rectangles.
