# Syntax for extended triangle

## Commands

Commands are executed in order to update variables 

```
Command := single-Command  
        |  Command; single-Command

single-Command := "skip"
               |  "V-name" := Expression
               |  Identifier "(" Actual-Parameter-Sequence ")" 
               |  "let" Declaration "in" Command "end"
               |  "if" Expression "then" Command RestOfIf
               |  "repeat" iterative-boolean-declaration command-execution "end"
               |  "repeat" command-Execution iterative-boolean-declaration "end"
               |  "repeat" "for" range-var-declaration ".." Expression command-Execution "end"
               |  "repeat" "for" range-var-declaration ".." Expression iterative-boolean-declaration Command-Execution "end"
               |  "repeat" "for" in-var-declaration Expression command-Execution "end"

range-var-declaration := Identifier ":=" "range" Expression

RestOfIf := "|" Expression "then" Command RestOfIf
         |  "else" Command "end"

               
command-Execution := "do" Command

iterative-boolean-declaration := "while" Expression
                              |  "until" Expression

```

## Expressions

Expresions are evaluated to yield a value.

```
Expression := secondary-Expression
           |  "let" Declaration "in" Expression
           |  "if" Expression "then" Expression "else" Expression

secondary-Expression := primary-Expression
                     |  secondary-Expression Operator primary-Expression

primary-Expression := Integer-Literal
                   |  Character-Literal
                   |  V-name
                   |  Identifier "(" Actual-Parameter-Sequence ")"
                   |  Operator primary-Expression
                   |  "(" Expression ")"
                   |  "{" Record-Aggregate }
                   |  "[" Array-Aggregate "]"

Record-Aggregate := Identifier "~" Expression
                 |  Identifier "~" Expression "," Record-Aggregate

Array-Aggregate := Expression
                |  Expression, Array-Aggregate
```

## Value or variable names


```
V-name := Identifier
       |  V-name "." Identifier
       |  V-name "[" Expression "]"
```


## Declarations

Declarations are elaborated to produce bindings

```
Declaration := compound-Declaration
            |  Declaration ";" compound-Declaration

compound-Declaration := single-Declaration
                     |  "recursive" Proc-Funcs "end"
                     |  "local" Declaration "in" Declaration "end"

Proc-Func := "proc" Identifier "(" Formal-Parameter-Sequence ")" "~" Command "end"
          |  "func" Identifier "(" Formal-Parameter-Sequence ")" ":" Type-denoter "~" Expression

Proc-Funcs ::= Proc-Func ("|" Proc-Func)+ 


single-Declaration := "const" Identifier "~" Expression
                   |  "var" Identifier ":" Type-denoter
                   |  "proc" Identifier "(" Formal-parameter-Sequence ")" "~" Command "end"
                   |  "func" Identifier "(" Formal-Parameter-Sequence ")" ":" Type-denoter "~" Expression
                   |  "type" Identifier "~" Type-denoter
                   |  "var" Identifier ":=" Expression

```

## Parameters

```
Formal-Parameter-Sequence := 
                          |  proper-Formal-Parameter-Sequence

proper-Formal-Parameter-Sequence := Formal-Parameter
                                 |  Formal-Parameter "," proper-Formal-Parameter-Sequence

Formal-Parameter := Identifier ":" Type-denoter
                 |  "var" Identifier ":" Type-denoter
                 |  "proc" Identifier "(" Formal-Parameter-Sequence ")"
                 |  "func" Identifier "(" Formal-Parameter-Sequence ")" ":" Type-denoter

proper-Actual-Parameter-Sequence := Actual-Parameter
                                 |  Actual-Parameter, proper-Actual-Parameter-Sequence

Actual-Parameter := Expression
                 |  "var" V-name
                 |  "proc" Identifier
                 |  "func" Identifier
```

## Type-denoters

```

Type-denoter := Identifier
             |  "array" Integer-Literal "of" Type-denoter
             |  "record" Record-Type-denoter "end"

Record-Type-denoter := Identifier ":" Type-denoter
                    |  Identifier ":", Record-Type-denoter

```

## Lexicon


```
Program ::= (Token | Comment | Blank)*

Token := Inteteger-Literal | Character-Literal | Identifier | Operator |
         "array" | "const" | "do" | "else" | "end" | "func" |
         "if" | "in" | "let" | "of" | "proc" | "record" | "then" | "type" |
         "for" | "from" | "local" "range" "recursive" "repeat" "skip" "to" |
         "until" | "when" | "var" | "while" | "." | ":" | ";" | "," | "," | 
         ":=" | "~" | "(" | ")" | "[" | "]" | "{" | "}" | "|" | ".."

Integer-Literal := Digit Digit*

Character-Literal := 'Graphic'

Identifier := Letter(Letter "|" Digit)*

Operator := Op-Character Op-Character*

Comment := "!" Graphic* end-of-line

Graphic := Letter | Digit | Op=character | space | tab | "." | ":" | ";" |
           "," | "~" | "(" | ")" | "[" | "]" | "{" | "}" | "_" | "|" | "!" |
           "'" | "`" | """ | "#" | "$"

```