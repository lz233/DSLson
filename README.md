# DSLson

Write Json With DSL.

## Usage

Input:

```kotlin
val json = json {
        element {
            int("int", 233)
            float("float", 233.33f)
            string("string", "233")
            boolean("boolean", true)
            element("jsonObject") {
                int("int", 233)
                float("float", 233.33f)
                string("string", "233")
                boolean("boolean", true)
                array("jsonArray") {
                    int(233)
                    float(233.33f)
                    string("233")
                    boolean(true)
                }
            }
        }
    }
    println(ReformatJsonUtil.stringToJson(json))
```

Output:

```json
{
  "int": 233,
  "float": 233.33,
  "string": "233",
  "boolean": true,
  "jsonObject": {
    "int": 233,
    "float": 233.33,
    "string": "233",
    "boolean": true,
    "jsonArray": [
      233,
      233.33,
      "233",
      true
    ]
  }
}
```