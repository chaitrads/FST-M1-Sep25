# Take username of the players

user1_name = input("Enter Player 1 Name: ")
user2_name = input("Enter Player 2 Name: ")

cond="yes"
# Checking who wins
while(cond=="yes" or cond=="y"):
    
        
    # Take user Choices:

    user1_answer = input(f"Enter {user1_name}'s choice: ").lower()
    user2_answer = input(f"Enter {user2_name}'s choice: ").lower()
    if((user1_answer == "rock" or user1_answer =="paper" or user1_answer =="scissors" ) and (user2_answer == "rock" or user2_answer =="paper" or user2_answer =="scissors")):
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
    else:
        print("Invalid input! You have not entered rock, paper or scissors, try again.")
        
    test = input("Do you want to play again? ").lower()
    if(test=="y" or test=="yes"):
        pass
    else:
        cond="no"
        
print("Thanks for playing")