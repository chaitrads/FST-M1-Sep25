import pytest

@pytest.mark.parametrize("earned, spent, expected", [(30,10,20), (20,2,18), (90,50,40), ( 10,1 ,10)])
def test_balance(wallet, earned, spent, expected):
    #Add earned money
    wallet += earned
    # Subtract the spent money
    wallet -=spent
    #check the final balance 
    assert wallet == expected
