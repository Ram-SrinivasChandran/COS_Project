CREATE TABLE "user" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"user_name"	TEXT NOT NULL UNIQUE,
	"password"	TEXT NOT NULL,
	"role"	TEXT NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE "food_menu" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL UNIQUE,
	"type"	TEXT NOT NULL,
	"availabilityOn"	TEXT NOT NULL,
	PRIMARY KEY("id")
);;
CREATE TABLE "food_item" (
	"id"	INTEGER NOT NULL,
	"name"	TEXT NOT NULL,
	"cost"	REAL NOT NULL,
	"quantity"	INTEGER NOT NULL,
	PRIMARY KEY("id")
);
CREATE TABLE "food_menu_food_item_map" (
	"id"	INTEGER NOT NULL,
	"food_menu_id"	INTEGER,
	"food_item_id"	INTEGER,
	CONSTRAINT "fk_fooditem" FOREIGN KEY("food_item_id") REFERENCES "food_item"("id"),
	PRIMARY KEY("id"),
	CONSTRAINT "fk_foodmenu" FOREIGN KEY("food_menu_id") REFERENCES "food_menu"("id")
);
CREATE TABLE "order" (
	"id"	INTEGER NOT NULL,
	"user_id"	INTEGER NOT NULL,
	"total_cost"	REAL NOT NULL,
	"email"	TEXT NOT NULL,
	"phone_number"	INTEGER NOT NULL,
	"order_location"	TEXT NOT NULL,
	"status"	TEXT NOT NULL,
	"order_on"	TIMESTAMP NOT NULL,
	"delivery_on"	TIMESTAMP NOT NULL,
	PRIMARY KEY("id"),
	CONSTRAINT "fk_user" FOREIGN KEY("user_id") REFERENCES "user"("id")
);
CREATE TABLE "order_item" (
	"id"	INTEGER NOT NULL,
	"order_id"	INTEGER,
	"food_item_id"	INTEGER,
	"quantity"	INTEGER NOT NULL,
	"cost"	REAL NOT NULL,
	CONSTRAINT "fk_food_item" FOREIGN KEY("food_item_id") REFERENCES "food_item"("id"),
	PRIMARY KEY("id"),
	CONSTRAINT "fk_order" FOREIGN KEY("order_id") REFERENCES "order"("id")
);
