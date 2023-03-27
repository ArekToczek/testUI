#!/usr/bin/env python
#
# Author: Arkadiusz Toczek
#
# Usage: gen_json_from_pattern.py .\pattern.json gen 10
#
# Script generate *.json files defined in input pattern file (pattern.json)
# Values are generated according pattern description:
# eg. for pattern <S2-40> randomly generate string with lenght between 2 and 40 characters
# for pattern <I18-100> randomly generate number with value in range 18-100
#

def check_pattern(pattern):
  str_pattern='IS'
  
  #check pattern type  
  if not (pattern[0] in str_pattern):
    return False
  #check range delimiter
  if not ('-' in pattern):
    return False

  patt=pattern[1:len(pattern)]
  patt_1=patt.split("-")[0]
  patt_2=patt.split("-")[1]  
  try:
    l=int(patt_1)
    l=int(patt_2)
  except ValueError:    
    return False  

  return True  

def gen_value_from_pattern(pattern):
  patt=pattern[1:len(pattern)]
  patt_1=patt.split("-")[0]
  patt_2=patt.split("-")[1]
  #generate string
  if pattern[0] == 'S':
      gen_str_len=random.randrange(int(patt_1),int(patt_2))      
      gen_str=''
      for x in range(0, gen_str_len):
          gen_str=gen_str + chr(random.randrange(97, 123))  
      return(gen_str)
  #generate number  
  elif pattern[0] == 'I':
      gen_str=str(random.randrange(int(patt_1), int(patt_2)))
      return(gen_str)
  else:
      return('ERROR')

def create_file_from_pattern(file_patt, file_new):
    #pattern processing
    f = open(file_new, "w")
    with open(file_patt,"r") as file:
        for line in file:            
            new_line=''
            #line without pattern
            if line.count('<') == 0 and line.count('>') == 0:
                new_line=line                
            #change pattern in line(set value)
            elif line.count('<') == 1 and line.count('>') == 1 and line.index('<') < line.index('>'):
                part1=line[0:line.index('<')]
                part2=line[line.index('>')+1:len(line)]            
                pattern=line[line.index('<')+1:line.index('>')]            
                if not check_pattern(pattern):
                    msg='Improper pattern: ' + pattern
                    exit(msg)
                part_gen=gen_value_from_pattern(pattern)            
                new_line=part1 + part_gen + part2
            #inconsistency in line    
            else:
                msg='Inconsistency in pattern line: ' + line
                exit(msg)            

            #print('Line:',line)    
            #print('Generated line:',new_line)
            f.write(new_line)    
                        
    f.close()
   
     
import random
import string
import sys
 
# total arguments
n = len(sys.argv)
if n != 4 :
    print('\nScript generate *.json files defined in input pattern file (pattern.json)')
    print('Please input parameters: <pattern file path> <name for output files> <number of generated files>')
    print('Usage:')
    print('gen_json_from_pattern.py .\\pattern.json gen 10')
    exit(1)


file_pattern_path=sys.argv[1]
file_name=sys.argv[2]
file_count=int(sys.argv[3])

for x in range(1, file_count + 1):
    file_new_name=str(x) + file_name + ".json"
    create_file_from_pattern(file_pattern_path,file_new_name)
    
print('File generation finished')
exit(0)


