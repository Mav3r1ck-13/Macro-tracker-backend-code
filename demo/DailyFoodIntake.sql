BEGIN TRANSACTION;

DROP TABLE IF EXISTS daily_food_intake, macros, users;

CREATE TABLE daily_food_intake (
    intake_id serial NOT NULL,
    user_id integer NOT NULL,
    protein int NOT NULL,
    carbs int NOT NULL,
    fats int NOT NULL,
    meal varchar(100) NOT NULL,
    food_name varchar(1000) NOT NULL,
    CONSTRAINT pk_daily_food_intake PRIMARY KEY (intake_id)
);

CREATE TABLE macros (
	macros_goal_id serial NOT NULL,
	protein_goal int NOT NULL,
	carbs_goal int NOT NULL,
	fats_goal int NOT NULL,
	calories int,
	CONSTRAINT pk_macros PRIMARY KEY (macros_goal_id)
);

CREATE TABLE users (
    user_id serial NOT NULL,
    username varchar(50) NOT NULL,
    first_name varchar(20) NOT NULL,
    last_name varchar(20) NOT NULL,
    email varchar(30) NOT NULL,
    password_hash varchar(200) NOT NULL,
    role varchar(50) NOT NULL,
    CONSTRAINT pk_users PRIMARY KEY (user_id),
    CONSTRAINT uc_users_username UNIQUE (username)
);

ALTER TABLE daily_food_intake ADD CONSTRAINT fk_daily_food_intake_user_id FOREIGN KEY(user_id)
REFERENCES users (user_id);

INSERT INTO users (user_id, username, first_name, last_name, email, password_hash, role) 
VALUES (1, 'user', 'Megan', 'McGaughey','24ksusb@gmail.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');

INSERT INTO users (user_id, username, first_name, last_name, email, password_hash, role) 
VALUES (2, 'admin', 'Ang', 'Young', 'angieyou3@gmail.com', '$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');

INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)
VALUES (1, 2, 19, 3, 2, 'Snack', '1st Phorm Protein');

INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)
VALUES (2, 2, 5, 19, 3, 'Lunch', 'Flour Tortillas, Soft Taco, Carb Balance');

INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)
VALUES (3, 2, 6, 1, 2.5, 'Breakfast', 'Cheese Heads, String Cheese, Light');

INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)
VALUES (4, 2, 14, 30, 2, 'Dinner', 'Flapjack and Waffle Mix');

INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)
VALUES (5, 2, 2, 17, 3, 'Snack', 'Granola Bar');

INSERT INTO daily_food_intake (intake_id, user_id, protein, carbs, fats, meal, food_name)
VALUES (?,?,?,?,?,?,?);

SELECT intake_id, user_id, protein, carbs, fats, meal, food_name
FROM daily_food_intake;

SELECT intake_id, user_id, protein, carbs, fats, meal, food_name
FROM daily_food_intake
WHERE intake_id = 2;

SELECT *
FROM daily_food_intake;

SELECT *
FROM users;

COMMIT TRANSACTION;

