def process(filename):
    """
    :param filename: is a txt file that contains a non negative song id for each line of a song lyric.
                     The format of the file look like this :
                     0:an example
                     33:of the text file
    :return: a text file called sorted_words.txt. This each line in this file contains word's song id and the word it
             self. And all this words are sort alphabetically and then by its song id.
             An example is:
             an:0
             example:0
    """

    file = open(filename + ".txt", "r")

    # To hold the word tuples read from the text file that has the song lyrics
    lyrics = []

    for line in file:
        # To remove the \n from each line
        line = line.strip()

        # To split the song id and the lyric line
        [song_id, lyric_line] = line.split(":")

        # Place the song id and the lyric line into a tuple
        lyrics.append((int(song_id), lyric_line))

    file.close()

    # To sort the lyric lines by their song id first
    lyrics = count_sort(lyrics)

    # Holds the words with their song ids.
    list_of_words = []

    for lyric_line in lyrics:
        [song_id, lyric_line] = lyric_line

        # Split the lyric line into words
        lyric_words = lyric_line.split(" ")

        for word in lyric_words:
            word_tuple = (song_id, word)

            list_of_words.append(word_tuple)

    # To sort the list_of_words by the words in ascending order using radix sort
    list_of_sorted_words = radix_sort(list_of_words)

    # To create and write a new file to print the sorted words
    new_file = open("sorted_words.txt", "w")
    for word_tuple in list_of_sorted_words:
        [song_id, word] = word_tuple
        new_file.write(word + ":" + str(song_id) + "\n")

    new_file.close()


def radix_sort(list_of_words):
    """
    :param list_of_words: takes in a list of tuples that contain (song_id, word)
    :return: a lexicographically sorted list

    By using radix sort the time complexity of this function is O(TM), where T is the total number of words in the
    inputted file and M is the length of the longest word.
    """
    max_len_word = len(list_of_words[0][1])
    # To find the length of the longest word in list_of_words
    for word in list_of_words:
        # word format: (song ID, lyric word)
        if len(word[1]) > max_len_word:
            max_len_word = len(word[1])

    # To sort the list in ascending order starting from least significant character to the most significant
    for i in range(max_len_word - 1, -1, -1):
        list_of_words = counting_sort(list_of_words, i)

    return list_of_words


def counting_sort(list_of_word_tuples, char_index):
    """
    :param list_of_word_tuples: list containing words with their song ids and it slowly sorted with the char_index placing
                                letter of the word
    :param char_index: a pointer, which indicates the placing of which all the letter has been sorted.
                        It starts from the longest length of word -1 and slowly decrement by 1.
                        the words are sorted by the char_index letter of the words in the list of words
    :return: the first part of the list is not sorted till the start_index, start_index onwards hold all the words that
             has been sorted by the char_index letter.


    """
    NO_OF_LETTERS = 26
    ASCII_A = ord('a')

    # To hold the number of times the alphabet has appeared at the given character index of the word
    counting = [0] * (NO_OF_LETTERS)
    # To hold the number of words that were bigger than the char_index ( number of words to be sorted at the character
    # index)
    total_count = 0
    for word_tuple in list_of_word_tuples:
        # Tuple format: (song ID, word)
        word = word_tuple[1]

        # Checks whether the length of the word is bigger than the char_index
        if len(word) > char_index:
            counting[ord(word[char_index]) - ASCII_A] += 1
            total_count += 1

    # To hold the position of the word's character
    position = [0] * (NO_OF_LETTERS)

    # To have a stable sort for every character, it takes the number of times the previous character is repeated add
    # with the previous index for that previous character
    for i in range(1, len(position)):
        position[i] = position[i - 1] + counting[i - 1]

    new_list = [0] * len(list_of_word_tuples)
    # Index of where the non sorted words start
    index = 0
    # Index of where the sorted list (by character, char_index) start
    start_index = len(list_of_word_tuples) - total_count

    for word_tuple in list_of_word_tuples:
        word = word_tuple[1]

        # Checks whether the length of the word should go to the sorted part of the array or not
        if len(word) > char_index:
            # Finding the index for the position array
            pos_index = ord(word[char_index]) - ASCII_A
            # So that the sorted words are to one side (the left side)
            new_list[position[pos_index] + start_index] = word_tuple
            # To go to the next index for the next word_tuple that has the same word
            position[pos_index] += 1
        else:
            # Adding the non sorted word to non sorted part of the list
            new_list[index] = word_tuple
            index += 1

    return new_list


def count_sort(my_list):
    # Used to sort the song ids in ascending order
    my_max = my_list[0][0]

    # To find the largest song ID
    for k in range(1, len(my_list)):
        if my_list[k][0] > my_max:
            my_max = my_list[k][0]

    # To include the largest song ID
    counting = [0] * (my_max + 1)

    for k in range(0, len(my_list)):
        counting[my_list[k][0]] += 1

    position = [0] * (my_max + 1)

    for i in range(1, len(position)):
        position[i] = position[i-1] + counting[i-1]

    # To hold the sorted array
    new_list = [0] * len(my_list)

    for word in my_list:
        new_list[position[word[0]]] = word
        position[word[0]] += 1

    return new_list


def collate(filename):
    """
    :param filename: text file that contains a sort list of words of song lyrics
    :return: a collated text file that collates all the same words together and displays the song ids next to each other
             An example would be:
             a:0 344
             example:0
    The time complexity of this function is also O(TM)
    """
    file = open(filename + ".txt", "r")
    # To hold multiple tuples that hold the song ID and the word
    list_of_words = []

    for word_line in file:
        word_line = word_line.strip()

        [word, song_id] = word_line.split(":")

        # Tuple format : (song ID, word)
        word_tuple = (int(song_id), word)
        list_of_words.append(word_tuple)

    file.close()

    # To hold the word and the list of song IDs for that word
    list_of_collate_ids = []

    (song_id, word_1) = list_of_words[0]
    list_of_collate_ids.append([word_1, [song_id]])

    # Index for the list_of_collate_ids
    index = 0

    for word_tuple in list_of_words:
        (song_id, word_2) = word_tuple

        # If the previous word is the same as the current one
        if word_1 == word_2:
            # To get the list of song IDs for word_1
            # list_of_collate_ids's element format : [ word, [ song ID 1, song ID 2]]
            list_of_id = list_of_collate_ids[index][1]

            # If the current song ID is the same as the previous one
            # No need to append the current song ID, so that are no repetition of song IDs
            if list_of_id[-1] == song_id:
                word_1 = word_2
            # If the current song ID is no the same as the previous one
            else:
                # Adds the new song ID to the list
                list_of_id.append(song_id)
                # Updates the list_of_collate_ids with the newly added song ID to the word_1
                list_of_collate_ids[index][1] = list_of_id
                word_1 = word_2
        # If there is a new word
        else:
            list_of_collate_ids.append([word_2, [song_id]])
            # Increment the index so that we can add more collate words in to list_of_collate_ids
            index += 1
            word_1 = word_2

    # To create a new file that will hold the collated IDs
    new_file = open("collated_ids.txt", "w")
    for collate_ids in list_of_collate_ids:
        [word, list_of_ids] = collate_ids
        string_of_ids = ""

        # To print the song IDs with a space between them
        for index in range(len(list_of_ids) - 1):
            song_id = list_of_ids[index]
            string_of_ids += str(song_id) + " "

        # So that there is no space at the back of the last IDs
        string_of_ids += str(list_of_ids[-1])

        # To write a new line that has the format word: song_ID_1 song_ID_2
        new_file.write(word + ":" + string_of_ids + "\n")

    new_file.close()


def lookup(collated_file, query_file):
    """
    :param collated_file: Is a text file that contains words with their collated id
    :param query_file: List of words
    :return: List of results, where either it is the corresponding song id or "Not found"

    Uses binary search in order to find for the query road.
    Time complexity of the function is O(q x Mlog(U) + P), where q is the number of words in the query file, M is the
    length of the longest word in any song, U is the number of lines in collated file and P is the total number of ids
    in the output.
    """
    coll_file = open(collated_file + ".txt", "r")

    # To hold the collated ids
    list_of_collated_ids = []
    for coll_line in coll_file:
        coll_line = coll_line.strip()
        [word, song_ids] = coll_line.split(":")

        list_of_collated_ids.append((word, song_ids))

    coll_file.close()

    que_file = open(query_file + ".txt", "r")

    list_of_query_words = []

    for que_line in que_file:
        que_word = que_line.strip()
        list_of_query_words.append(que_word)

    que_file.close()

    new_file = open("song_ids.txt", "w")

    # To search for the given query words in the list of words in the list_of_collated_ids using binary search method
    # Outputs either the song ID of that query word or "Not found"
    for word in list_of_query_words:
        new_file.write(binary_search(list_of_collated_ids, word) + "\n")

    new_file.close()


def binary_search(collated_list, query_word):
    low = 0
    high = len(collated_list) - 1

    while low <= high:
        mid = (low + high) // 2
        [coll_word, coll_id] = collated_list[mid]
        if coll_word == query_word:
            return coll_id

        elif coll_word > query_word:
            high = mid - 1

        else:
            low = mid + 1

    return "Not found"


if __name__ == "__main__":
    process("example_songs")
    collate("example_sorted_words")
    lookup("example_collated_ids", "example_queries")

