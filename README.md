# hogwarts-houses
An application to help Hogwarts professors managing the castle.

*Reimagining the original CodeCool project [Hogwarts Houses - Sprint 1](https://github.com/CodecoolGlobal/hogwarts-houses-1-java-mscobblepot) without Thymeleaf*

What if I told you that magic is real? What if I told you that wizards, witches, and everything from the world of Harry Potter is real, and they need you now? In our fast-paced, modern world, they can't solve everything with spells and potions anymore. That's why now more than ever, Hogwarts School of Witchcraft and Wizardry needs a little bit of Muggle technology, to make the management of this enormous castle less of a headache. Of course, since witches and wizards have no idea about technology, you'll disguise your API as a set of more wizard-friendly spells, so that it's more intuitive for the target audience. Let the techno... ahem, magic, begin!

## Locus Omnis!

Dumbledore tasked prof. McGonagall with writing a list of all rooms on a piece of parchment. The deadline is tomorrow, so she needs your help.

    A list of all rooms is returned when calling the /rooms endpoint with the GET method.

## Invenio Locus!

"Keep an eye on the staircases. They like to change." This turned out to be correct, which makes it really easy to get lost. Poor Luna just got lost in the building and the only thing she remembers is the room number. Help Luna find her room by its number.

    The room with the specified ID is returned when calling the /rooms/{roomId} endpoint with the GET method.

## Locus Novus!

By some magical accident, Hogwarts is completely out of rooms! We need to create some new empty rooms, so that the students have a place to live. A room should be big enough for more than one student.

    A new room can be added when calling the /rooms endpoint with the POST method.

## Renovo Locus!

Some rooms require a bit of renovation, as they have become old, messy, and ugly over the centuries of usage.

    The room with the specified ID is updated when calling the /rooms endpoint with the PUT method.

## Erado Locus!

While playing around with the Locus Novus spell, a few misplaced rooms have popped up accidentally, and now they block some corridors. We need a reverse spell to unmake a room.

    The room with the specified ID is deleted when calling the /rooms/{roomID} endpoint with the DELETE method.

## The list of students

Harry Potter and Ron Weasley have just arrived at Hogwarts. As long as they are not on the list of the students, Filch will not allow them to enter. Put them on the list, so they can enter before the dinner is over.

    A list of all students is returned when calling the /students endpoint with the GET method.

## Help Neville find a room

Poor Neville! He lost his frog on the train and arrived quite late to school. Are there any empty rooms left? Help Neville find all available rooms, so that he has a place to stay.

    A list of all available rooms is returned when calling the /rooms/available endpoint with the GET method.

## Help Ron move

Hermione and Ron just had an argument about their pets. Crookshanks tried to catch and eat Scabbers (again!). Concerned about safety of his rat, Ron can only stay in a room in which nobody has a cat or an owl. Help Ron find a safe room for his pet.

    A list of rooms, residents of which have no cats or owls, is returned when calling the /rooms/rat-owners endpoint with the GET method.
