# Npc programming menu
The following program was developed as part of the Java programming bootcamp at ITAcademy Barcelona.

1. [Prompt](#prompt)
2. [Java concepts applied](#code)
3. [Notes](#note)

## 1. Prompt <a name = "prompt"></a>
They're asking us to program the NPCs for a role-playing game. There are three categories of NPCs: Farmer, Thief, and Merchant and they all sell items. Each NPC is located in a city. The items have a name, type, price, and wear percentage.
- The farmer has up to 5 items to sell and adds a 2% tax to the original price. When a farmer adds an item to their inventory, it deteriorates by 15%.
- The thief has up to 3 items and doesn't charge taxes. When a thief adds an item to their inventory, it deteriorates by 25%.
- The merchant has up to 7 items and charges a 4% tax. A merchant knows very well how to store their items so they don't spoil


The application allows:
1. To check the items of a seller.
2. To check the sellers in a city.
3. To display the cheapest item among all sellers in a city.
4. To display all items of a certain type sorted by price (ascending).
5. To simulate the purchase of an item from an NPC.
6. To simulate the sale of an item to an NPC.
> If someone tries to add more items than an NPC can sell, an exception will display the message: "[Inventory full! The seller cannot buy the item]."
7. To serialize the information of each NPC (name, category, location, items: name, type, price, wear) into a JSON file.

## 2. Concepts applied <a name = "code"></a>
- Inheritance
> Npc -> Seller -> Farmer / Thief / Merchant <br>
> For the scope of this project, Seller class could be avoided and extend directly from Npc. However, the decision to implement Seller class was made having future bigger projects in mind, where the game could have other Npcs that were not sellers.
- Polymorphism
- Java Collections
- Personalized Exception
- Lambdas
- Data Serialization (to json file)

## 3. Notes <a name = "note"></a>
CODE CONSIDERATIONS
- There is only 1 player
- For the player to buy or sell an Item to a Seller Npc, they both have to be in the same city. <br>
- One character can have multiple identical items. <br>

FUTURE POSSIBLE IMPROVEMENTS
- If only one player, player class could implement Singleton pattern
- Data initialization could be done reading data from csv files
- Could make menu option to create npc
