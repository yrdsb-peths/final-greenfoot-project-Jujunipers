# Final Greenfoot Project
This is the README.md file.

Planty Pot
Made by Julia Yang
January 2024

*IMPORTANT*
When the repo is cloned, an error occurs to the WateringCan class (I'm not sure why). Just rename "Wateringcan" to "WateringCan"

HOW TO PLAY
Plant seeds and water them to grow! Sell grown plants for money to buy more seeds! You can close the game and the plants will continue growing.

ARRAYS
An array of Pot objects is created in MyWorld.
An array of PlantData objects (data for each plant to be saved across files) is created in PlayerData.

CHEATS
Press/hold 'A' to pass time faster (plants will grow thirsty and grow faster).
(This is an idle game meant to be played in the background while doing other things, so speedrunning is not recommended)

HOW THE PLANT GROWTH WORKS (behind the scenes)...
- currentGrowth (int variable containing amount of plant growth) increases itself by 1 every 10 secs.
- Watering the plant increases the currentGrowth by the value of the plant's thirst.
- Plant's thirst increases by 1 for every act() loop. When thirst reaches 15, thirst icon appears on the plant (indicating that plant can be watered), and thirst icon increases in size as the plant's thirst increases.
- When plant reaches max thirstiness (thirst = 600), currentGrowth stops increasing on its own every 10 secs.
- Plant moves on to the next growth stage upon currentGrowth having increased to certain milestones.

Consider using **Markdown** syntax to format the text in this file. [Markdown basics](https://www.markdownguide.org/getting-started/)


