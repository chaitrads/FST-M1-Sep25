# Take username of the players

user1_name = input("Enter Player 1 Name: ").lower()
user2_name = input("Enter Player 2 Name: ").lower()

# Take user Choices:

user1_answer = input(f"Enter {user1_name}'s choice: ")
user2_answer = input(f"Enter {user2_name}'s choice: ")

# Checking who wins

if(user1_answer==user2_answer):
    print("Its a TIE! no one wins")
elif(user1_answer=="rock" and user2_answer=="scissors"):
    print(f"{user1_name} wins as Rock Beats Scissors")
elif(user1_answer=="rock" and user2_answer=="paper"):
    print(f"{user2_name} wins as Paper Beats Rock")
elif(user1_answer=="paper" and user2_answer=="scissors"):
    print(f"{user2_name} wins as Scissors Beats Paper")
elif(user1_answer=="paper" and user2_answer=="rock"):
    print(f"{user1_name} wins as Paper Beats Rock")
elif(user1_answer=="scissors" and user2_answer =="paper"):
    print(f"{user1_name} wins as Scissors Beats Paper")
elif(user1_answer=="scissors" and user2_answer =="rock"):
    print(f"{user2_name} wins as Rock Beats Scissors")
else:
    print("Invalid input! You have not entered rock, paper or scissors, try again.")