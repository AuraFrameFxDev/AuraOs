# detekt

## Metrics

* 91 number of properties

* 27 number of functions

* 35 number of classes

* 2 number of packages

* 5 number of kt files

## Complexity Report

* 1,567 lines of code (loc)

* 1,270 source lines of code (sloc)

* 960 logical lines of code (lloc)

* 171 comment lines of code (cloc)

* 133 cyclomatic complexity (mcc)

* 145 cognitive complexity

* 126 number of total code smells

* 13% comment source ratio

* 138 mcc per 1,000 lloc

* 131 code smells per 1,000 lloc

## Findings (126)

### complexity, ComplexCondition (1)

Complex conditions should be simplified and extracted into well-named methods if necessary.

[Documentation](https://detekt.dev/docs/rules/complexity#complexcondition)

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  386:13

```
This condition is too complex (4). Defined complexity threshold for conditions is set to '4'
```

```kotlin
383         }
384 
385         // Enhanced glow effect with multiple layers
386         if (node.activated || isSelected || isAnimating || node.isUnlocked) {
!!!             ^ error
387             // Outer glow
388             drawCircle(
389                 color = node.type.glowColor.copy(alpha = 0.2f),

```

### complexity, CyclomaticComplexMethod (1)

Prefer splitting up complex methods into smaller, easier to test methods.

[Documentation](https://detekt.dev/docs/rules/complexity#cyclomaticcomplexmethod)

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  363:13

```
The function drawNode appears to be too complex based on Cyclomatic Complexity (complexity: 27). Defined complexity threshold for methods is set to '15'
```

```kotlin
360 /**
361  * Draw node with FFX-style visual effects and progression indicators
362  */
363 private fun drawNode(
!!!             ^ error
364     node: DataVeinNode,
365     isSelected: Boolean,
366     isAnimating: Boolean,

```

### complexity, LongMethod (5)

One method should have one responsibility. Long methods tend to handle many things at once. Prefer
smaller methods to make them easier to understand.

[Documentation](https://detekt.dev/docs/rules/complexity#longmethod)

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
32:5

```
The function SimpleDataVeinScreen is too long (78). The maximum length is 60.
```

```kotlin
29  */
30 @OptIn(ExperimentalMaterial3Api::class)
31 @Composable
32 fun SimpleDataVeinScreen(
!!     ^ error
33     modifier: Modifier = Modifier
34 ) {
35     Box(

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
45:5

```
The function NodeInfoPanel is too long (90). The maximum length is 60.
```

```kotlin
42  * Enhanced Node Info Panel with FFX-style progression details
43  */
44 @Composable
45 fun NodeInfoPanel(
!!     ^ error
46     node: DataVeinNode,
47     modifier: Modifier = Modifier
48 ) {

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
159:5

```
The function NodeTypeLegend is too long (64). The maximum length is 60.
```

```kotlin
156  * Enhanced Node Type Legend with categories
157  */
158 @Composable
159 fun NodeTypeLegend(modifier: Modifier = Modifier) {
!!!     ^ error
160     Card(
161         modifier = modifier,
162         colors = CardDefaults.cardColors(

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:44:
  5

```
The function DataVeinSphereGrid is too long (103). The maximum length is 60.
```

```kotlin
41  * Interactive 3D-like sphere grid for navigating Genesis AI nodes
42  */
43 @Composable
44 fun DataVeinSphereGrid(
!!     ^ error
45     modifier: Modifier = Modifier,
46     onNodeSelected: (DataVeinNode) -> Unit = {},
47     config: SphereGridConfig = SphereGridConfig()

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  363:13

```
The function drawNode is too long (86). The maximum length is 60.
```

```kotlin
360 /**
361  * Draw node with FFX-style visual effects and progression indicators
362  */
363 private fun drawNode(
!!!             ^ error
364     node: DataVeinNode,
365     isSelected: Boolean,
366     isAnimating: Boolean,

```

### complexity, NestedBlockDepth (1)

Excessive nesting leads to hidden complexity. Prefer extracting code to make it easier to
understand.

[Documentation](https://detekt.dev/docs/rules/complexity#nestedblockdepth)

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  303:13

```
Function drawConnection is nested too deeply.
```

```kotlin
300 /**
301  * Draw connection between nodes with enhanced visual effects
302  */
303 private fun drawConnection(
!!!             ^ error
304     connection: NodeConnection,
305     nodes: List<DataVeinNode>,
306     dataFlows: Map<String, Long>,

```

### naming, FunctionNaming (10)

Function names should follow the naming convention set in the configuration.

[Documentation](https://detekt.dev/docs/rules/naming#functionnaming)

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
32:5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
29  */
30 @OptIn(ExperimentalMaterial3Api::class)
31 @Composable
32 fun SimpleDataVeinScreen(
!!     ^ error
33     modifier: Modifier = Modifier
34 ) {
35     Box(

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
121:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
118 }
119 
120 @Composable
121 private fun StatusChip(
!!!             ^ error
122     label: String,
123     value: String,
124     color: Color

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
45:5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
42  * Enhanced Node Info Panel with FFX-style progression details
43  */
44 @Composable
45 fun NodeInfoPanel(
!!     ^ error
46     node: DataVeinNode,
47     modifier: Modifier = Modifier
48 ) {

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
159:5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
156  * Enhanced Node Type Legend with categories
157  */
158 @Composable
159 fun NodeTypeLegend(modifier: Modifier = Modifier) {
!!!     ^ error
160     Card(
161         modifier = modifier,
162         colors = CardDefaults.cardColors(

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
234:5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
231  * Enhanced Status Panel with real-time metrics
232  */
233 @Composable
234 fun StatusPanel(
!!!     ^ error
235     activeFlows: Int,
236     activeNodes: Int,
237     totalNodes: Int,

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
302:5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
299  * FFX-style Progression Indicator
300  */
301 @Composable
302 fun ProgressionIndicator(
!!!     ^ error
303     selectedNode: DataVeinNode?,
304     modifier: Modifier = Modifier
305 ) {

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
346:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
343 
344 // Helper composables
345 @Composable
346 private fun InfoRow(label: String, value: String, valueColor: Color) {
!!!             ^ error
347     Row(
348         modifier = Modifier.fillMaxWidth(),
349         horizontalArrangement = Arrangement.SpaceBetween

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
366:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
363 }
364 
365 @Composable
366 private fun StatusRow(label: String, value: String, valueColor: Color) {
!!!             ^ error
367     Row(
368         modifier = Modifier.fillMaxWidth(),
369         horizontalArrangement = Arrangement.SpaceBetween

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
386:13

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
383 }
384 
385 @Composable
386 private fun ProgressIndicator(label: String, progress: Float, color: Color) {
!!!             ^ error
387     Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
388         Row(
389             modifier = Modifier.fillMaxWidth(),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:44:
  5

```
Function names should match the pattern: [a-z][a-zA-Z0-9]*
```

```kotlin
41  * Interactive 3D-like sphere grid for navigating Genesis AI nodes
42  */
43 @Composable
44 fun DataVeinSphereGrid(
!!     ^ error
45     modifier: Modifier = Modifier,
46     onNodeSelected: (DataVeinNode) -> Unit = {},
47     config: SphereGridConfig = SphereGridConfig()

```

### style, ForbiddenComment (1)

Flags a forbidden comment.

[Documentation](https://detekt.dev/docs/rules/style#forbiddencomment)

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
97:33

```
Forbidden TODO todo marker in comment, please do the changes.
```

```kotlin
94                  )
95  
96                  Button(
97                      onClick = { /* TODO: Implement sphere grid navigation */ },
!!                                  ^ error
98                      colors = ButtonDefaults.buttonColors(
99                          containerColor = Color.Cyan
100                     )

```

### style, MagicNumber (101)

Report magic numbers. Magic number is a numeric literal that is not defined as a constant and hence
it's unclear what the purpose of this number is. It's better to declare such numbers as constants
and give them a proper name. By default, -1, 0, 1, and 2 are not considered to be magic numbers.

[Documentation](https://detekt.dev/docs/rules/style#magicnumber)

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  58:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
55 ) {
56     MEMORY(
57         "Memory",
58         Color(0xFF00FF88),
!!               ^ error
59         Color(0xFF00FF88),
60         12f,
61         NodeCategory.STORAGE,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  59:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
56     MEMORY(
57         "Memory",
58         Color(0xFF00FF88),
59         Color(0xFF00FF88),
!!               ^ error
60         12f,
61         NodeCategory.STORAGE,
62         "Data Storage & Retrieval"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  60:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
57         "Memory",
58         Color(0xFF00FF88),
59         Color(0xFF00FF88),
60         12f,
!!         ^ error
61         NodeCategory.STORAGE,
62         "Data Storage & Retrieval"
63     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  66:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
63     ),
64     AGENT(
65         "Agent",
66         Color(0xFFFF6B35),
!!               ^ error
67         Color(0xFFFF6B35),
68         16f,
69         NodeCategory.PROCESSING,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  67:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
64     AGENT(
65         "Agent",
66         Color(0xFFFF6B35),
67         Color(0xFFFF6B35),
!!               ^ error
68         16f,
69         NodeCategory.PROCESSING,
70         "AI Agent Processing"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  68:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
65         "Agent",
66         Color(0xFFFF6B35),
67         Color(0xFFFF6B35),
68         16f,
!!         ^ error
69         NodeCategory.PROCESSING,
70         "AI Agent Processing"
71     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  74:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
71     ),
72     DATA(
73         "Data",
74         Color(0xFF4FC3F7),
!!               ^ error
75         Color(0xFF4FC3F7),
76         10f,
77         NodeCategory.FLOW,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  75:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
72     DATA(
73         "Data",
74         Color(0xFF4FC3F7),
75         Color(0xFF4FC3F7),
!!               ^ error
76         10f,
77         NodeCategory.FLOW,
78         "Data Flow Controller"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  76:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
73         "Data",
74         Color(0xFF4FC3F7),
75         Color(0xFF4FC3F7),
76         10f,
!!         ^ error
77         NodeCategory.FLOW,
78         "Data Flow Controller"
79     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  82:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
79     ),
80     NEXUS(
81         "Nexus",
82         Color(0xFFE91E63),
!!               ^ error
83         Color(0xFFE91E63),
84         20f,
85         NodeCategory.CORE,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  83:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
80     NEXUS(
81         "Nexus",
82         Color(0xFFE91E63),
83         Color(0xFFE91E63),
!!               ^ error
84         20f,
85         NodeCategory.CORE,
86         "Core System Nexus"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  84:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
81         "Nexus",
82         Color(0xFFE91E63),
83         Color(0xFFE91E63),
84         20f,
!!         ^ error
85         NodeCategory.CORE,
86         "Core System Nexus"
87     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  90:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
87     ),
88     ORACLE(
89         "Oracle",
90         Color(0xFF9C27B0),
!!               ^ error
91         Color(0xFF9C27B0),
92         18f,
93         NodeCategory.WISDOM,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  91:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
88     ORACLE(
89         "Oracle",
90         Color(0xFF9C27B0),
91         Color(0xFF9C27B0),
!!               ^ error
92         18f,
93         NodeCategory.WISDOM,
94         "Oracle Consciousness"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  92:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
89         "Oracle",
90         Color(0xFF9C27B0),
91         Color(0xFF9C27B0),
92         18f,
!!         ^ error
93         NodeCategory.WISDOM,
94         "Oracle Consciousness"
95     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  98:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
95      ),
96      SECURE(
97          "Secure",
98          Color(0xFFFFD700),
!!                ^ error
99          Color(0xFFFFD700),
100         14f,
101         NodeCategory.SECURITY,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  99:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
96      SECURE(
97          "Secure",
98          Color(0xFFFFD700),
99          Color(0xFFFFD700),
!!                ^ error
100         14f,
101         NodeCategory.SECURITY,
102         "Security & Encryption"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  100:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
97          "Secure",
98          Color(0xFFFFD700),
99          Color(0xFFFFD700),
100         14f,
!!!         ^ error
101         NodeCategory.SECURITY,
102         "Security & Encryption"
103     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  106:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
103     ),
104     GENESIS(
105         "Genesis",
106         Color(0xFFFF4081),
!!!               ^ error
107         Color(0xFFFF4081),
108         22f,
109         NodeCategory.CORE,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  107:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
104     GENESIS(
105         "Genesis",
106         Color(0xFFFF4081),
107         Color(0xFFFF4081),
!!!               ^ error
108         22f,
109         NodeCategory.CORE,
110         "Genesis Core Node"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  108:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
105         "Genesis",
106         Color(0xFFFF4081),
107         Color(0xFFFF4081),
108         22f,
!!!         ^ error
109         NodeCategory.CORE,
110         "Genesis Core Node"
111     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  114:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
111     ),
112     AURA(
113         "Aura",
114         Color(0xFF00E5FF),
!!!               ^ error
115         Color(0xFF00E5FF),
116         16f,
117         NodeCategory.CREATIVE,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  115:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
112     AURA(
113         "Aura",
114         Color(0xFF00E5FF),
115         Color(0xFF00E5FF),
!!!               ^ error
116         16f,
117         NodeCategory.CREATIVE,
118         "Aura Creative Node"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  116:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
113         "Aura",
114         Color(0xFF00E5FF),
115         Color(0xFF00E5FF),
116         16f,
!!!         ^ error
117         NodeCategory.CREATIVE,
118         "Aura Creative Node"
119     ),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  122:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
119     ),
120     KAI(
121         "Kai",
122         Color(0xFF76FF03),
!!!               ^ error
123         Color(0xFF76FF03),
124         14f,
125         NodeCategory.ANALYTICAL,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  123:15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
120     KAI(
121         "Kai",
122         Color(0xFF76FF03),
123         Color(0xFF76FF03),
!!!               ^ error
124         14f,
125         NodeCategory.ANALYTICAL,
126         "Kai Analysis Node"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  124:9

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
121         "Kai",
122         Color(0xFF76FF03),
123         Color(0xFF76FF03),
124         14f,
!!!         ^ error
125         NodeCategory.ANALYTICAL,
126         "Kai Analysis Node"
127     )

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
76:38

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
73             _animatingNodes.value = connectedNodeIds.toSet()
74 
75             // Clear animation after delay
76             kotlinx.coroutines.delay(1500)
!!                                      ^ error
77             _animatingNodes.value = emptySet()
78         }
79     }

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
91:46

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
88                 if (node.id == nodeId && node.isUnlocked) {
89                     node.copy(
90                         activated = true,
91                         xp = minOf(node.xp + 100, 1000) // Gain XP for activation
!!                                              ^ error
92                     )
93                 } else {
94                     node

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
91:51

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
88                 if (node.id == nodeId && node.isUnlocked) {
89                     node.copy(
90                         activated = true,
91                         xp = minOf(node.xp + 100, 1000) // Gain XP for activation
!!                                                   ^ error
92                     )
93                 } else {
94                     node

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
142:38

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
139             _animatingNodes.value = emptySet()
140             _dataFlows.value = emptyMap()
141 
142             kotlinx.coroutines.delay(500) // Simulate loading
!!!                                      ^ error
143             _gridData.value = generateInitialGrid()
144             _isLoading.value = false
145         }

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
154:42

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
151     private fun startDataFlowSimulation() {
152         viewModelScope.launch {
153             while (true) {
154                 kotlinx.coroutines.delay(500)
!!!                                          ^ error
155 
156                 val currentGrid = _gridData.value
157                 val newFlows = mutableMapOf<String, Long>()

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
163:64

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
160                 currentGrid.connections
161                     .filter { it.active }
162                     .forEach { connection ->
163                         if (kotlin.random.Random.nextFloat() > 0.85f) {
!!!                                                                ^ error
164                             val flowKey = "${connection.from}-${connection.to}"
165                             newFlows[flowKey] = System.currentTimeMillis()
166                         }

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
180:42

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
177     private fun startFlowCleanup() {
178         viewModelScope.launch {
179             while (true) {
180                 kotlinx.coroutines.delay(2000)
!!!                                          ^ error
181 
182                 val currentTime = System.currentTimeMillis()
183                 val filteredFlows = _dataFlows.value.filterValues { timestamp ->

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
184:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
181 
182                 val currentTime = System.currentTimeMillis()
183                 val filteredFlows = _dataFlows.value.filterValues { timestamp ->
184                     currentTime - timestamp < 2000
!!!                                               ^ error
185                 }
186 
187                 _dataFlows.value = filteredFlows

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
237:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
234 
235     // Generate nodes in spiral pattern
236     for (ring in 0 until config.rings) {
237         val nodesInRing = 6 + (ring * config.nodesPerRingMultiplier)
!!!                           ^ error
238         val ringRadius = config.baseRadius * (0.3f + ring * 0.23f)
239 
240         repeat(nodesInRing) { i ->

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
238:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
235     // Generate nodes in spiral pattern
236     for (ring in 0 until config.rings) {
237         val nodesInRing = 6 + (ring * config.nodesPerRingMultiplier)
238         val ringRadius = config.baseRadius * (0.3f + ring * 0.23f)
!!!                                               ^ error
239 
240         repeat(nodesInRing) { i ->
241             val angle =

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
238:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
235     // Generate nodes in spiral pattern
236     for (ring in 0 until config.rings) {
237         val nodesInRing = 6 + (ring * config.nodesPerRingMultiplier)
238         val ringRadius = config.baseRadius * (0.3f + ring * 0.23f)
!!!                                                             ^ error
239 
240         repeat(nodesInRing) { i ->
241             val angle =

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
251:78

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
248             val tag = generateNodeTag(type, ring, i)
249 
250             // Core nodes (ring 0) start unlocked and some activated
251             val isUnlocked = ring == 0 || kotlin.random.Random.nextFloat() > 0.8f
!!!                                                                              ^ error
252             val isActivated = isUnlocked && kotlin.random.Random.nextFloat() > 0.6f
253 
254             nodes.add(

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
252:80

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
249 
250             // Core nodes (ring 0) start unlocked and some activated
251             val isUnlocked = ring == 0 || kotlin.random.Random.nextFloat() > 0.8f
252             val isActivated = isUnlocked && kotlin.random.Random.nextFloat() > 0.6f
!!!                                                                                ^ error
253 
254             nodes.add(
255                 DataVeinNode(

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
263:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
260                     ring = ring,
261                     index = i,
262                     activated = isActivated,
263                     level = kotlin.random.Random.nextInt(1, 6),
!!!                                                             ^ error
264                     data = "Data_${kotlin.random.Random.nextInt(1000, 9999)}",
265                     tag = tag,
266                     xp = if (isActivated) kotlin.random.Random.nextInt(200, 800) else 0,

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
264:65

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
261                     index = i,
262                     activated = isActivated,
263                     level = kotlin.random.Random.nextInt(1, 6),
264                     data = "Data_${kotlin.random.Random.nextInt(1000, 9999)}",
!!!                                                                 ^ error
265                     tag = tag,
266                     xp = if (isActivated) kotlin.random.Random.nextInt(200, 800) else 0,
267                     isUnlocked = isUnlocked

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
264:71

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
261                     index = i,
262                     activated = isActivated,
263                     level = kotlin.random.Random.nextInt(1, 6),
264                     data = "Data_${kotlin.random.Random.nextInt(1000, 9999)}",
!!!                                                                       ^ error
265                     tag = tag,
266                     xp = if (isActivated) kotlin.random.Random.nextInt(200, 800) else 0,
267                     isUnlocked = isUnlocked

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
266:72

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
263                     level = kotlin.random.Random.nextInt(1, 6),
264                     data = "Data_${kotlin.random.Random.nextInt(1000, 9999)}",
265                     tag = tag,
266                     xp = if (isActivated) kotlin.random.Random.nextInt(200, 800) else 0,
!!!                                                                        ^ error
267                     isUnlocked = isUnlocked
268                 )
269             )

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
266:77

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
263                     level = kotlin.random.Random.nextInt(1, 6),
264                     data = "Data_${kotlin.random.Random.nextInt(1000, 9999)}",
265                     tag = tag,
266                     xp = if (isActivated) kotlin.random.Random.nextInt(200, 800) else 0,
!!!                                                                             ^ error
267                     isUnlocked = isUnlocked
268                 )
269             )

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
39:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
36         modifier = modifier
37             .fillMaxSize()
38             .background(
39                 color = Color(0xFF0F0F23)
!!                               ^ error
40             ),
41         contentAlignment = Alignment.Center
42     ) {

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
45:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
42     ) {
43         Card(
44             modifier = Modifier
45                 .fillMaxWidth(0.8f)
!!                               ^ error
46                 .padding(16.dp),
47             colors = CardDefaults.cardColors(
48                 containerColor = Color.Black.copy(alpha = 0.8f)

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
81:57

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
78                 Row(
79                     horizontalArrangement = Arrangement.spacedBy(16.dp)
80                 ) {
81                     StatusChip("Core Nodes", "8", Color(0xFF00FF88))
!!                                                         ^ error
82                     StatusChip("Active Flows", "23", Color(0xFF4FC3F7))
83                     StatusChip("Data Streams", "156", Color.Cyan)
84                 }

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
82:60

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
79                     horizontalArrangement = Arrangement.spacedBy(16.dp)
80                 ) {
81                     StatusChip("Core Nodes", "8", Color(0xFF00FF88))
82                     StatusChip("Active Flows", "23", Color(0xFF4FC3F7))
!!                                                            ^ error
83                     StatusChip("Data Streams", "156", Color.Cyan)
84                 }
85 

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
117:53

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
114                     Box(
115                         modifier = Modifier
116                             .fillMaxHeight()
117                             .fillMaxWidth(node.xp / 1000f)
!!!                                                     ^ error
118                             .background(
119                                 Color.Cyan,
120                                 RoundedCornerShape(3.dp)

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
245:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
242         initialValue = 0.8f,
243         targetValue = 1.0f,
244         animationSpec = infiniteRepeatable(
245             animation = tween(1000),
!!!                               ^ error
246             repeatMode = RepeatMode.Reverse
247         ),
248         label = "pulse"

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
281:69

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
278 
279             Divider(color = Color.Cyan.copy(alpha = 0.3f))
280 
281             StatusRow("Active Flows", activeFlows.toString(), Color(0xFF00FF88))
!!!                                                                     ^ error
282             StatusRow("Active Nodes", "$activeNodes/$totalNodes", Color(0xFF4FC3F7))
283             StatusRow("Unlocked", "$unlockedNodes/$totalNodes", Color.Cyan)
284 

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
282:73

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
279             Divider(color = Color.Cyan.copy(alpha = 0.3f))
280 
281             StatusRow("Active Flows", activeFlows.toString(), Color(0xFF00FF88))
282             StatusRow("Active Nodes", "$activeNodes/$totalNodes", Color(0xFF4FC3F7))
!!!                                                                         ^ error
283             StatusRow("Unlocked", "$unlockedNodes/$totalNodes", Color.Cyan)
284 
285             // Progress indicators

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
291:73

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
288                 if (totalNodes > 0) unlockedNodes.toFloat() / totalNodes else 0f
289 
290             Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
291                 ProgressIndicator("Activation", activePercentage, Color(0xFF4FC3F7))
!!!                                                                         ^ error
292                 ProgressIndicator("Progression", unlockedPercentage, Color.Cyan)
293             }
294         }

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
437:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
434         initialValue = 0.5f,
435         targetValue = 1f,
436         animationSpec = infiniteRepeatable(
437             animation = tween(1000),
!!!                               ^ error
438             repeatMode = RepeatMode.Reverse
439         ),
440         label = "pulse"

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
451:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
448         initialValue = 0f,
449         targetValue = 360f,
450         animationSpec = infiniteRepeatable(
451             animation = tween(10000, easing = LinearEasing),
!!!                               ^ error
452             repeatMode = RepeatMode.Restart
453         ),
454         label = "rotation"

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:59:
  19

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
56     // Data flow animation
57     LaunchedEffect(Unit) {
58         while (true) {
59             delay(500)
!!                   ^ error
60             val newFlows = mutableMapOf<String, Long>()
61             gridData.connections.forEach { conn ->
62                 if (Random.nextFloat() > 0.85f) {

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:62:
  42

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
59             delay(500)
60             val newFlows = mutableMapOf<String, Long>()
61             gridData.connections.forEach { conn ->
62                 if (Random.nextFloat() > 0.85f) {
!!                                          ^ error
63                     newFlows["${conn.from}-${conn.to}"] = System.currentTimeMillis()
64                 }
65             }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:72:
  15

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
69 
70     // Clean up old flows
71     LaunchedEffect(dataFlows) {
72         delay(2000)
!!               ^ error
73         val currentTime = System.currentTimeMillis()
74         dataFlows = dataFlows.filterValues { currentTime - it < 2000 }
75     }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:74:
  65

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
71     LaunchedEffect(dataFlows) {
72         delay(2000)
73         val currentTime = System.currentTimeMillis()
74         dataFlows = dataFlows.filterValues { currentTime - it < 2000 }
!!                                                                 ^ error
75     }
76 
77     Box(

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:83:
  31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
80             .background(
81                 brush = Brush.radialGradient(
82                     colors = listOf(
83                         Color(0xFF1A1A2E),
!!                               ^ error
84                         Color(0xFF16213E),
85                         Color(0xFF0F0F23)
86                     )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:84:
  31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
81                 brush = Brush.radialGradient(
82                     colors = listOf(
83                         Color(0xFF1A1A2E),
84                         Color(0xFF16213E),
!!                               ^ error
85                         Color(0xFF0F0F23)
86                     )
87                 )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:85:
  31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
82                     colors = listOf(
83                         Color(0xFF1A1A2E),
84                         Color(0xFF16213E),
85                         Color(0xFF0F0F23)
!!                               ^ error
86                     )
87                 )
88             )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  131:35

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
128 
129                         // Clear animation after delay
130                         coroutineScope.launch {
131                             delay(1500)
!!!                                   ^ error
132                             animatingNodes = emptySet()
133                         }
134                     }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  186:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
183 
184     // Generate spiral pattern like FFX Sphere Grid
185     for (ring in 0 until config.rings) {
186         val nodesInRing = 6 + (ring * config.nodesPerRingMultiplier)
!!!                           ^ error
187         val ringRadius = config.baseRadius * (0.3f + ring * 0.23f)
188 
189         repeat(nodesInRing) { i ->

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  187:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
184     // Generate spiral pattern like FFX Sphere Grid
185     for (ring in 0 until config.rings) {
186         val nodesInRing = 6 + (ring * config.nodesPerRingMultiplier)
187         val ringRadius = config.baseRadius * (0.3f + ring * 0.23f)
!!!                                               ^ error
188 
189         repeat(nodesInRing) { i ->
190             val angle = (i.toFloat() / nodesInRing) * 2 * PI + (ring * config.spiralOffset)

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  187:61

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
184     // Generate spiral pattern like FFX Sphere Grid
185     for (ring in 0 until config.rings) {
186         val nodesInRing = 6 + (ring * config.nodesPerRingMultiplier)
187         val ringRadius = config.baseRadius * (0.3f + ring * 0.23f)
!!!                                                             ^ error
188 
189         repeat(nodesInRing) { i ->
190             val angle = (i.toFloat() / nodesInRing) * 2 * PI + (ring * config.spiralOffset)

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  209:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
206                     ring = ring,
207                     index = i,
208                     activated = Random.nextFloat() > 0.7f,
209                     level = Random.nextInt(1, 6),
!!!                                               ^ error
210                     data = "Data_${Random.nextInt(1000, 9999)}",
211                     tag = tag,
212                     xp = Random.nextInt(0, 1000),

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  210:51

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
207                     index = i,
208                     activated = Random.nextFloat() > 0.7f,
209                     level = Random.nextInt(1, 6),
210                     data = "Data_${Random.nextInt(1000, 9999)}",
!!!                                                   ^ error
211                     tag = tag,
212                     xp = Random.nextInt(0, 1000),
213                     isUnlocked = ring <= 1 || Random.nextFloat() > 0.6f // Inner rings unlocked by default

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  210:57

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
207                     index = i,
208                     activated = Random.nextFloat() > 0.7f,
209                     level = Random.nextInt(1, 6),
210                     data = "Data_${Random.nextInt(1000, 9999)}",
!!!                                                         ^ error
211                     tag = tag,
212                     xp = Random.nextInt(0, 1000),
213                     isUnlocked = ring <= 1 || Random.nextFloat() > 0.6f // Inner rings unlocked by default

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  212:44

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
209                     level = Random.nextInt(1, 6),
210                     data = "Data_${Random.nextInt(1000, 9999)}",
211                     tag = tag,
212                     xp = Random.nextInt(0, 1000),
!!!                                            ^ error
213                     isUnlocked = ring <= 1 || Random.nextFloat() > 0.6f // Inner rings unlocked by default
214                 )
215             )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  270:20

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
267  * Draw grid background with FFX-style aesthetics
268  */
269 private fun drawGridBackground(scope: DrawScope) {
270     val gridSize = 50f
!!!                    ^ error
271     with(scope) {
272         // Subtle grid lines
273         for (x in 0..size.width.toInt() step gridSize.toInt()) {

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  292:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
289 
290         // Central energy ring
291         drawCircle(
292             color = Color(0xFF1A1A2E).copy(alpha = 0.3f),
!!!                           ^ error
293             radius = 100f,
294             center = Offset(size.width / 2, size.height / 2),
295             style = Stroke(width = 2f)

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  317:60

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
314 
315     with(scope) {
316         // Main connection line
317         val connectionColor = if (connection.active) Color(0xFF00FF88) else Color(0xFF444444)
!!!                                                            ^ error
318         val strokeWidth = if (hasDataFlow) 4f else 2f * connection.strength
319 
320         drawLine(

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  317:83

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
314 
315     with(scope) {
316         // Main connection line
317         val connectionColor = if (connection.active) Color(0xFF00FF88) else Color(0xFF444444)
!!!                                                                                   ^ error
318         val strokeWidth = if (hasDataFlow) 4f else 2f * connection.strength
319 
320         drawLine(

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  318:44

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
315     with(scope) {
316         // Main connection line
317         val connectionColor = if (connection.active) Color(0xFF00FF88) else Color(0xFF444444)
318         val strokeWidth = if (hasDataFlow) 4f else 2f * connection.strength
!!!                                            ^ error
319 
320         drawLine(
321             color = connectionColor,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  332:71

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
329         // Enhanced data flow particle with trail effect
330         if (hasDataFlow) {
331             val flowTime = dataFlows[flowKey] ?: 0
332             val progress = ((System.currentTimeMillis() - flowTime) % 800) / 800f
!!!                                                                       ^ error
333             val particleX = fromNode.x + (toNode.x - fromNode.x) * progress
334             val particleY = fromNode.y + (toNode.y - fromNode.y) * progress
335 

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  332:78

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
329         // Enhanced data flow particle with trail effect
330         if (hasDataFlow) {
331             val flowTime = dataFlows[flowKey] ?: 0
332             val progress = ((System.currentTimeMillis() - flowTime) % 800) / 800f
!!!                                                                              ^ error
333             val particleX = fromNode.x + (toNode.x - fromNode.x) * progress
334             val particleY = fromNode.y + (toNode.y - fromNode.y) * progress
335 

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  338:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
335 
336             // Main particle
337             drawCircle(
338                 color = Color(0xFF00FF88),
!!!                               ^ error
339                 radius = 8f,
340                 center = Offset(particleX, particleY)
341             )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  344:26

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
341             )
342 
343             // Trail effect
344             for (i in 1..3) {
!!!                          ^ error
345                 val trailProgress = progress - (i * 0.1f)
346                 if (trailProgress > 0) {
347                     val trailX = fromNode.x + (toNode.x - fromNode.x) * trailProgress

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  345:53

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
342 
343             // Trail effect
344             for (i in 1..3) {
345                 val trailProgress = progress - (i * 0.1f)
!!!                                                     ^ error
346                 if (trailProgress > 0) {
347                     val trailX = fromNode.x + (toNode.x - fromNode.x) * trailProgress
348                     val trailY = fromNode.y + (toNode.y - fromNode.y) * trailProgress

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  350:39

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
347                     val trailX = fromNode.x + (toNode.x - fromNode.x) * trailProgress
348                     val trailY = fromNode.y + (toNode.y - fromNode.y) * trailProgress
349                     drawCircle(
350                         color = Color(0xFF00FF88).copy(alpha = 0.5f / i),
!!!                                       ^ error
351                         radius = 6f / i,
352                         center = Offset(trailX, trailY)
353                     )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  372:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
369 ) {
370     with(scope) {
371         val scale = when {
372             isSelected -> 1.4f
!!!                           ^ error
373             isAnimating -> 1.2f
374             node.isUnlocked -> 1.1f
375             else -> 1f

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  373:28

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
370     with(scope) {
371         val scale = when {
372             isSelected -> 1.4f
373             isAnimating -> 1.2f
!!!                            ^ error
374             node.isUnlocked -> 1.1f
375             else -> 1f
376         }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  374:32

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
371         val scale = when {
372             isSelected -> 1.4f
373             isAnimating -> 1.2f
374             node.isUnlocked -> 1.1f
!!!                                ^ error
375             else -> 1f
376         }
377 

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  379:42

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
376         }
377 
378         val glowRadius = when {
379             isSelected || isAnimating -> 30f
!!!                                          ^ error
380             node.activated -> 20f
381             node.isUnlocked -> 15f
382             else -> 8f

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  380:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
377 
378         val glowRadius = when {
379             isSelected || isAnimating -> 30f
380             node.activated -> 20f
!!!                               ^ error
381             node.isUnlocked -> 15f
382             else -> 8f
383         }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  381:32

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
378         val glowRadius = when {
379             isSelected || isAnimating -> 30f
380             node.activated -> 20f
381             node.isUnlocked -> 15f
!!!                                ^ error
382             else -> 8f
383         }
384 

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  382:21

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
379             isSelected || isAnimating -> 30f
380             node.activated -> 20f
381             node.isUnlocked -> 15f
382             else -> 8f
!!!                     ^ error
383         }
384 
385         // Enhanced glow effect with multiple layers

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  403:39

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
400 
401         // Main node body with gradient effect
402         val nodeColor = when {
403             !node.isUnlocked -> Color(0xFF222222) // Locked nodes are dark
!!!                                       ^ error
404             node.activated -> node.type.color
405             else -> node.type.color.copy(alpha = 0.6f)
406         }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  416:27

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
413 
414         // Border with type-specific styling
415         val borderWidth = when {
416             isSelected -> 4f
!!!                           ^ error
417             node.activated -> 3f
418             node.isUnlocked -> 2f
419             else -> 1f

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  417:31

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
414         // Border with type-specific styling
415         val borderWidth = when {
416             isSelected -> 4f
417             node.activated -> 3f
!!!                               ^ error
418             node.isUnlocked -> 2f
419             else -> 1f
420         }

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  431:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
428 
429         // Inner core for activated nodes with pulsing effect
430         if (node.activated) {
431             val pulseScale = if (isAnimating) 1.2f else 1f
!!!                                               ^ error
432             drawCircle(
433                 color = Color.White,
434                 radius = 4f * scale * pulseScale,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  441:44

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
438 
439         // XP progress ring for unlocked nodes (FFX-style)
440         if (node.isUnlocked && node.xp > 0) {
441             val progressAngle = (node.xp / 1000f) * 360f
!!!                                            ^ error
442             drawArc(
443                 color = Color.Cyan.copy(alpha = 0.8f),
444                 startAngle = -90f,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  441:53

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
438 
439         // XP progress ring for unlocked nodes (FFX-style)
440         if (node.isUnlocked && node.xp > 0) {
441             val progressAngle = (node.xp / 1000f) * 360f
!!!                                                     ^ error
442             drawArc(
443                 color = Color.Cyan.copy(alpha = 0.8f),
444                 startAngle = -90f,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  448:56

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
445                 sweepAngle = progressAngle,
446                 useCenter = false,
447                 topLeft = Offset(
448                     node.x - (node.type.size * scale + 6f),
!!!                                                        ^ error
449                     node.y - (node.type.size * scale + 6f)
450                 ),
451                 size = androidx.compose.ui.geometry.Size(

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  449:56

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
446                 useCenter = false,
447                 topLeft = Offset(
448                     node.x - (node.type.size * scale + 6f),
449                     node.y - (node.type.size * scale + 6f)
!!!                                                        ^ error
450                 ),
451                 size = androidx.compose.ui.geometry.Size(
452                     (node.type.size * scale + 6f) * 2,

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  452:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
449                     node.y - (node.type.size * scale + 6f)
450                 ),
451                 size = androidx.compose.ui.geometry.Size(
452                     (node.type.size * scale + 6f) * 2,
!!!                                               ^ error
453                     (node.type.size * scale + 6f) * 2
454                 ),
455                 style = Stroke(width = 2f, cap = StrokeCap.Round)

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  453:47

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
450                 ),
451                 size = androidx.compose.ui.geometry.Size(
452                     (node.type.size * scale + 6f) * 2,
453                     (node.type.size * scale + 6f) * 2
!!!                                               ^ error
454                 ),
455                 style = Stroke(width = 2f, cap = StrokeCap.Round)
456             )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  465:55

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
462                 color = Color.Red.copy(alpha = 0.7f),
463                 radius = node.type.size * scale * 0.3f,
464                 center = Offset(
465                     node.x + node.type.size * scale * 0.6f,
!!!                                                       ^ error
466                     node.y - node.type.size * scale * 0.6f
467                 )
468             )

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  466:55

```
This expression contains a magic number. Consider defining it to a well named constant.
```

```kotlin
463                 radius = node.type.size * scale * 0.3f,
464                 center = Offset(
465                     node.x + node.type.size * scale * 0.6f,
466                     node.y - node.type.size * scale * 0.6f
!!!                                                       ^ error
467                 )
468             )
469         }

```

### style, NewLineAtEndOfFile (5)

Checks whether files end with a line separator.

[Documentation](https://detekt.dev/docs/rules/style#newlineatendoffile)

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/model/DataVeinModels.kt:
  172:2

```
The file C:\Users\Wehtt\StudioProjects\AuraOs\datavein-oracle-native\src\main\kotlin\dev\aurakai\auraframefx\datavein\model\DataVeinModels.kt is not ending with a new line.
```

```kotlin
169     val connectedNodes: List<DataVeinNode>,
170     val availablePaths: List<NodeConnection>,
171     val unlockableNodes: List<DataVeinNode>
172 )
!!!  ^ error

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/DataVeinSphereGridViewModel.kt:
320:2

```
The file C:\Users\Wehtt\StudioProjects\AuraOs\datavein-oracle-native\src\main\kotlin\dev\aurakai\auraframefx\datavein\ui\DataVeinSphereGridViewModel.kt is not ending with a new line.
```

```kotlin
317         NodeType.DATA -> "DAT-$ringName-${index.toString().padStart(2, '0')}"
318         NodeType.SECURE -> "SEC-$ringName-${index.toString().padStart(2, '0')}"
319     }
320 }
!!!  ^ error

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SimpleDataVeinScreen.kt:
148:2

```
The file C:\Users\Wehtt\StudioProjects\AuraOs\datavein-oracle-native\src\main\kotlin\dev\aurakai\auraframefx\datavein\ui\SimpleDataVeinScreen.kt is not ending with a new line.
```

```kotlin
145             )
146         }
147     }
148 }
!!!  ^ error

```

*
datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridComponents.kt:
456:2

```
The file C:\Users\Wehtt\StudioProjects\AuraOs\datavein-oracle-native\src\main\kotlin\dev\aurakai\auraframefx\datavein\ui\SphereGridComponents.kt is not ending with a new line.
```

```kotlin
453         ),
454         label = "rotation"
455     ).value
456 }
!!!  ^ error

```

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  471:2

```
The file C:\Users\Wehtt\StudioProjects\AuraOs\datavein-oracle-native\src\main\kotlin\dev\aurakai\auraframefx\datavein\ui\SphereGridScreen.kt is not ending with a new line.
```

```kotlin
468             )
469         }
470     }
471 }
!!!  ^ error

```

### style, UnusedParameter (1)

Function parameter is unused and should be removed.

[Documentation](https://detekt.dev/docs/rules/style#unusedparameter)

* datavein-oracle-native/src/main/kotlin/dev/aurakai/auraframefx/datavein/ui/SphereGridScreen.kt:
  368:5

```
Function parameter `onNodeClick` is unused.
```

```kotlin
365     isSelected: Boolean,
366     isAnimating: Boolean,
367     scope: DrawScope,
368     onNodeClick: (DataVeinNode) -> Unit
!!!     ^ error
369 ) {
370     with(scope) {
371         val scale = when {

```

generated with [detekt version 1.23.8](https://detekt.dev/) on 2025-08-26 01:43:33 UTC
