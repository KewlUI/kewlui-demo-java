# Accordion

The Accordion control is a user interface component that allows users to expand and collapse content within a single container. It is designed to enhance the readability and organization of content by presenting it in a compact and efficient manner. Users may use this control to manage complex information while keeping a clean and organized view.

## Properties

### allowMultiple

boolean, Default: false

If `true`, multiple accordion items can be expanded at once.

### allowToggle

boolean, Default: false

If `true`, any expanded accordion item can be collapsed again.

### index

String

The index(es) of the expanded accordion item

### reduceMotion

boolean, Default: false

If `true`, height animation and transitions will be disabled.

### id

String

A unique id for the accordion item.

### isFocusable

boolean, Default: false

If `true`, the accordion item will be focusable.

# AccordionButton

The AccordionButton is a user interface component that allows users to expand and collapse sections of information by clicking on a button. It provides a convenient way to organize and present large amounts of information in a compact and intuitive manner. People might use it to improve the user experience of their website or application by making it easy and accessible to browse through different sections of content.

## Properties

### allowMultiple

boolean, Default: false

If `true`, multiple accordion items can be expanded at once.

### allowToggle

boolean, Default: false

If `true`, any expanded accordion item can be collapsed again.

### index

String

The index(es) of the expanded accordion item

### reduceMotion

boolean, Default: false

If `true`, height animation and transitions will be disabled.

### id

String

A unique id for the accordion item.

### isFocusable

boolean, Default: false

If `true`, the accordion item will be focusable.

# AccordionIcon

AccordionIcon is a UI control that displays an icon to indicate the state of an accordion component, either collapsed or expanded. It is ideal for users who want to visually communicate the state of an accordion in their web application.

## Properties

### allowMultiple

boolean, Default: false

If `true`, multiple accordion items can be expanded at once.

### allowToggle

boolean, Default: false

If `true`, any expanded accordion item can be collapsed again.

### index

String

The index(es) of the expanded accordion item

### reduceMotion

boolean, Default: false

If `true`, height animation and transitions will be disabled.

### id

String

A unique id for the accordion item.

### isFocusable

boolean, Default: false

If `true`, the accordion item will be focusable.

# AccordionItem

The AccordionItem control is a component that helps to create collapsible and expandable sections of content in a web application. It allows users to toggle between revealing and hiding information that is organized into sections. It is helpful for developers who want to create an easy-to-navigate interface that preserves space and allows users to focus on relevant content.

## Properties

### allowMultiple

boolean, Default: false

If `true`, multiple accordion items can be expanded at once.

### allowToggle

boolean, Default: false

If `true`, any expanded accordion item can be collapsed again.

### index

String

The index(es) of the expanded accordion item

### reduceMotion

boolean, Default: false

If `true`, height animation and transitions will be disabled.

### id

String

A unique id for the accordion item.

### isFocusable

boolean, Default: false

If `true`, the accordion item will be focusable.

# AccordionPanel

The AccordionPanel control is a UI component that displays collapsible panels stacked vertically. It allows users to expand or collapse panels to view or hide content, respectively. It is useful for displaying information in a structured and organized manner while saving screen real estate.

## Properties

### allowMultiple

boolean, Default: false

If `true`, multiple accordion items can be expanded at once.

### allowToggle

boolean, Default: false

If `true`, any expanded accordion item can be collapsed again.

### index

String

The index(es) of the expanded accordion item

### reduceMotion

boolean, Default: false

If `true`, height animation and transitions will be disabled.

### id

String

A unique id for the accordion item.

### isFocusable

boolean, Default: false

If `true`, the accordion item will be focusable.

# Alert

The Alert control is a user interface component that displays important information to users. It can be used to notify users about alerts, warnings, errors, or other important messages that need to be communicated. It is a useful tool for improving user experience by providing clear and concise messages that users can easily understand and act upon.

## Properties

### status

String, Default: info

Enumerations: info, warning, success, error, loading

The status of the alert

### variant

String, Default: subtle

Enumerations: subtle, left-accent, top-accent, solid

The variant of the Alert

# AlertDescription

The AlertDescription control displays a short message describing an alert or notification. It is commonly used in conjunction with an Alert component to provide additional context or details about the alert. It allows for clear and concise communication to the user about the purpose or potential consequences of the alert.

## Properties

### status

String, Default: info

Enumerations: info, warning, success, error, loading

The status of the alert

### variant

String, Default: subtle

Enumerations: subtle, left-accent, top-accent, solid

The variant of the Alert

# AlertDialog

The AlertDialog control is an interface component that pops up with important messages to be acknowledged by the user in order to proceed with the intended action. It can be used to prompt users for necessary actions or to display context-sensitive information.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# AlertIcon

The AlertIcon control displays an icon that corresponds to a specific type of alert, such as success or warning. It is used as a visual indicator alongside text or other components to convey important information to users quickly and efficiently.

## Properties

### status

String, Default: info

Enumerations: info, warning, success, error, loading

The status of the alert

### variant

String, Default: subtle

Enumerations: subtle, left-accent, top-accent, solid

The variant of the Alert

# AlertTitle

The AlertTitle control is a pre-built component that displays the title of an alert message. It is designed to be used within alert components to provide a clear and concise heading that summarizes the content of the alert. It can save time and effort when creating alert messages by providing a simple yet effective way to format the title of each message.

## Properties

### status

String, Default: info

Enumerations: info, warning, success, error, loading

The status of the alert

### variant

String, Default: subtle

Enumerations: subtle, left-accent, top-accent, solid

The variant of the Alert

# AnimationBox

Container that provides a background animation.  Animation can auto play. Value can be bool, (0-100), or 'play'/'loop' to set location.  Children are displayed on top of animation.

## Properties

### src

string

url to load animation data file

### animationData

string

lottie json string containing animation data

### autoPlay

boolean, Default: true

if not false, the animation will auto play

### loop

boolean, Default: true

if not false, the animation will loop on play

### speed

double, Default: 1

relative speed to show animation, relative to 1.0

### direction

boolean, Default: true

direction to play animation, true is forward

### useSubFrames

boolean, Default: true

use subframe interpolation for smoother animation

### opacity

double, Default: 0

opacity to use on children controls.  0 == invisible, 1 == fully visible

### zoomLevel

double, Default: 1

Amount to zoom in on the animation, increasing its size relative to the bounding container

### zoomLevelX

double, Default: 1

Amount to zoom in on the animation in X dir, increasing its size relative to the bounding container

### zoomLevelY

double, Default: 1

Amount to zoom in on the animation in Y dir, increasing its size relative to the bounding container

### translateX

double, Default: 0

Amount to translate the animation in X direction, - is left, + if right

### translateY

double, Default: 0

Amount to translate the animation in Y direction, - is left, + if right

### imageWidth

integer

CssSprites: if image mode, we split source image into many parts.  Each part is imageWidth width. See CSS Sprites

### imageHeight

integer

CssSprites: if image mode, we split source image into many parts.  Each part is imageHeight height. See CSS Sprites

### rowIndex

integer

CssSprites: If we have multiple rows in a css sprite, this chooses the row - (imageHeight*rowIndex)

### numFrames

integer

CssSprites:  Max number of frames in x direction

### fps

integer

CssSprites:  frames per second on animation

# AspectRatio

AspectRatio control is a component that allows you to maintain a fixed aspect ratio for an element. It adjusts the height or width of the element depending on the aspect ratio specified. It can be used to ensure that images or videos maintain their intended dimensions on different screen sizes without stretching or distorting.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# AutoWrap

The Wrap control allows for the wrapping of child elements within a container, creating a layout that adjusts to available space and can be responsive on different screen sizes. It can be useful when displaying a dynamic number of elements that need to be arranged in a specific order without requiring a fixed grid layout.

## Properties

### align

String

E.g. centre

### direction

String

E.g. row, column, row-reverse, column-reverse

### direction

String

E.g. row, column, row-reverse, column-reverse

### justify

String

E.g. row, column, row-reverse, column-reverse

### shouldWrapChildren

boolean, Default: true

items will be auto wrapped if true

### spacing

String

The space between each child

### spacingX

String

The space between each child x dir

### spacingY

String

The space between each child x dir

# Avatar

An Avatar control is a component that displays a user's profile image or initials in a circular container. It allows users to visually identify themselves or others in an application. Someone might use it to provide a more personalized experience or to easily distinguish between different users.

## Properties

### getInitials

String

Function to get the initials to display

### icon

icon

The default avatar used as fallback when `name`, and `src`is not specified.

### ignoreFallback

boolean, Default: false

If `true`, opt out of the avatar's `fallback` logic andrenders the `img` at all times.

### loading

String

Enumerations: eager, lazy

Defines loading strategy

### showBorder

boolean, Default: false

If `true`, the `Avatar` will show a border around it.Best for a group of avatars

### src

String

The image url of the `Avatar`

### srcSet

String

List of sources to use for different screen resolutions

### variant

String

The variant of the Avatar

### max

String

The maximum number of visible avatars

### spacing

any, Default: -0.75rem

The space between the avatars in the group.

# AvatarBadge

The AvatarBadge control is a component that displays an avatar image along with a badge notification. It is typically used to show a user's profile picture with a count or status badge, such as indicating the number of unread messages or notifications.

## Properties

### getInitials

String

Function to get the initials to display

### icon

icon

The default avatar used as fallback when `name`, and `src`is not specified.

### ignoreFallback

boolean, Default: false

If `true`, opt out of the avatar's `fallback` logic andrenders the `img` at all times.

### loading

String

Enumerations: eager, lazy

Defines loading strategy

### showBorder

boolean, Default: false

If `true`, the `Avatar` will show a border around it.Best for a group of avatars

### src

String

The image url of the `Avatar`

### srcSet

String

List of sources to use for different screen resolutions

### variant

String

The variant of the Avatar

### max

String

The maximum number of visible avatars

### spacing

any, Default: -0.75rem

The space between the avatars in the group.

# AvatarGroup

The AvatarGroup control is a component that allows for the display of multiple avatars in a single container with options for spacing, size, and tooltip display. It is useful for displaying a group of users or identifying members of a team.

## Properties

### getInitials

String

Function to get the initials to display

### icon

icon

The default avatar used as fallback when `name`, and `src`is not specified.

### ignoreFallback

boolean, Default: false

If `true`, opt out of the avatar's `fallback` logic andrenders the `img` at all times.

### loading

String

Enumerations: eager, lazy

Defines loading strategy

### showBorder

boolean, Default: false

If `true`, the `Avatar` will show a border around it.Best for a group of avatars

### src

String

The image url of the `Avatar`

### srcSet

String

List of sources to use for different screen resolutions

### variant

String

The variant of the Avatar

### max

String

The maximum number of visible avatars

### spacing

any, Default: -0.75rem

The space between the avatars in the group.

# Badge

The badge control enables the display of a small label or indicator on a user interface to provide information or functionality. It allows for easy identification of specific items or actions and can provide context to users. Users may use it to draw attention to important notifications or highlight key information.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# BorderCard

BorderCard creates a card with an image as the borders.  The middle sections are either repeated or strecthed

## Properties

### slice

String, Default: 20 20 20 20

relative to input image, border heights/widths in pixels or %'s. top height, right width, bottom height, left width

### borderWidth

String, Default: 20 20 20 20

relative to output, border heights/widths in pixels. top height, right width, bottom height, left width in pixels

### borderMargins

String

relative to output, how to change margins of child controls. e.g. '-20 -20 -20 -20'

### repeat

boolean, Default: true

if true, middle is repeated.  If false, middle of image is stretched.

### src

String

Url of image to use as border

### fill

boolean, Default: false

set true if you want to keep the middle of the box

### hueRotate

integer, Default: 0

hue rotate the background by this amount

### childZIndex

integer, Default: 1

Where to put children controls, 1=above border image, -1 below border image

# Box

A Box control is a basic layout element used to group and organize other UI components within a rectangular frame. It can be styled with various properties to adjust its size, color, border, and spacing. It is commonly used to create containers for text, images, buttons, and other interactive elements in a user interface. Its simplicity and flexibility make it a versatile building block for building web and mobile applications.

## Properties

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Breadcrumb

The Breadcrumb control is a navigation aid that displays a hierarchy of links showing the user their current location within a website or application. It allows users to track their progress and easily move back to any level of the hierarchy.

One might use it to improve navigation and provide users with a clear understanding of the structure of the website or application.

## Properties

### separator

any, Default: /

The visual separator between each breadcrumb item

### spacing

any, Default: 0.5rem

The left and right margin applied to the separator

# BreadcrumbItem

BreadcrumbItem is a navigation control used to display a single item in a breadcrumb trail. It allows users to keep track of their current location within a hierarchical site or application structure. It is useful for enhancing the user experience by providing clear navigation cues.

## Properties

### separator

any, Default: /

The visual separator between each breadcrumb item

### spacing

any, Default: 0.5rem

The left and right margin applied to the separator

# BreadcrumbLink

The BreadcrumbLink is a user interface component that displays a clickable link within a breadcrumb navigation. It is used to help users easily navigate and retrace their steps within a website or application.

## Properties

### separator

any, Default: /

The visual separator between each breadcrumb item

### spacing

any, Default: 0.5rem

The left and right margin applied to the separator

# BreadcrumbSeparator

BreadcrumbSeparator is a component that renders a separator to visually divide breadcrumb items. It provides a clear visual separation between individual breadcrumb items.

## Properties

### separator

any, Default: /

The visual separator between each breadcrumb item

### spacing

any, Default: 0.5rem

The left and right margin applied to the separator

# Button

The Button control is a user interface component that displays text or an icon and responds to user clicks. It allows users to trigger an action or navigate to a different section of an application. It's commonly used as a call-to-action or for displaying important messages.

## Properties

### iconSpacing

any

The space between the button icon and label.

### isActive

boolean, Default: false

If `true`, the button will be styled in its active state.

### isLoading

boolean, Default: false

If `true`, the button will show a spinner.

### leftIcon

icon

If added, the button will show an icon before the button's label.

### loadingText

any

The label to show in the button when `isLoading` is trueIf no text is passed, it only shows the spinner

### rightIcon

icon

If added, the button will show an icon after the button's label.

### spinner

icon

Replace the spinner component when `isLoading` is set to `true`

### spinnerPlacement

String, Default: start

Enumerations: start, end

It determines the placement of the spinner when isLoading is true

### variant

String

Enumerations: ghost, outline, solid, link, unstyled, rounded

The variant of the Button

### isAttached

boolean, Default: false

If `true`, the borderRadius of button that are direct children will be alteredto look flushed together

### spacing

any, Default: '0.5rem'

The spacing between the buttons

### aria-label

String

A11y: A label that describes the button

### icon

icon

The icon to be used in the button.

### isRound

boolean, Default: false

If `true`, the button will be perfectly round. Else, it'll be slightly round

### size

any

See SizeEnum, size of button

# ButtonGroup

A ButtonGroup control is a component in that groups a set of related buttons together and allows users to select one option at a time. It's useful for presenting a set of mutually exclusive options and making it clear which option is currently selected.

## Properties

### iconSpacing

any

The space between the button icon and label.

### isActive

boolean, Default: false

If `true`, the button will be styled in its active state.

### isLoading

boolean, Default: false

If `true`, the button will show a spinner.

### leftIcon

icon

If added, the button will show an icon before the button's label.

### loadingText

any

The label to show in the button when `isLoading` is trueIf no text is passed, it only shows the spinner

### rightIcon

icon

If added, the button will show an icon after the button's label.

### spinner

icon

Replace the spinner component when `isLoading` is set to `true`

### spinnerPlacement

String, Default: start

Enumerations: start, end

It determines the placement of the spinner when isLoading is true

### variant

String, Default: solid

Enumerations: ghost, outline, solid, link, unstyled

The variant of the Button

### isAttached

boolean, Default: false

If `true`, the borderRadius of button that are direct children will be alteredto look flushed together

### spacing

any, Default: '0.5rem'

The spacing between the buttons

### aria-label

String

A11y: A label that describes the button

### icon

icon

The icon to be used in the button.

### isRound

boolean, Default: false

If `true`, the button will be perfectly round. Else, it'll be slightly round

# Card

The Card control organizes information in a visually appealing container with flexible sizing, positioning, and content types. It could be used to display information such as news articles, user profiles, or product details.

## Properties

### variant

String, Default: elevated

Enumerations: elevated, outline, filled, unstyled

The variant of the Card

# CardBody

CardBody is a container component which provides a robust and structured layout for displaying content, such as text, images or buttons, within a card. It allows for easy implementation of visual hierarchy and improves the overall readability of the interface. One might use it to organize and present information in a clear and concise manner.

## Properties

### variant

String, Default: elevated

Enumerations: elevated, outline, filled, unstyled

The variant of the Card

# CardFooter

The CardFooter control is used to display a footer section at the bottom of a card component. It can contain any type of content, such as buttons or text. It helps to maintain a consistent and organized layout within the card component.

## Properties

### variant

String, Default: elevated

Enumerations: elevated, outline, filled, unstyled

The variant of the Card

# CardHeader

CardHeader is a pre-built component that creates a header section for a card with simple and customizable styling options. It allows developers to quickly and easily add a visually appealing header to their card components.

## Properties

### variant

String, Default: elevated

Enumerations: elevated, outline, filled, unstyled

The variant of the Card

# CardPricing

a pricing card normally used for displaying a pricing option

## Properties

### category

String

Category of the pricing, e.g. 'Basic', 'Professional'

### categoryColor

String

optional color of the pricing unit

### pricePreText

String

what to put in front of the price, e.g. '$'

### priceText

String

Price to show in large number

### priceFrequency

any

e.g. 'Monthly'

### features

stringlist

if set, will display a list of benefits of the deal

### icon

icon, Default:

The checked icon to use

### iconColor

String

The color of the checkbox icon when checked or indeterminate

### iconSize

any

The size of the checkbox icon when checked or indeterminate

### iconBgColor

String

Icon background color

# CardSocialProfile

A prebuild template with social profile information

## Properties

### backgroundImage

String

url of the background image to use at top

### profileImage

String

url of the profile image

### userName

String

name of the user

### userRole

String

What the user is/does

### badges

stringlist

list of text badges to place above footer

### stats

any

dictionary of interesting stats - e.g {'Followers':'23k'}

### onlineColor

any

If set to a valid color, a small coloured ball will appear next to the image.

# Carousel

A customizable carousel slider component for displaying content in a sliding format.

## Properties

### accessibility

boolean, Default: true

Enables tab control and arrow key navigation.

### adaptiveHeight

boolean, Default: false

Automatically adjusts the carousel height to the height of the currently displayed slide.

### autoplay

boolean, Default: false

Enables automatic cycling through slides.

### autoplaySpeed

integer, Default: 3000

The delay in milliseconds between automatically cycling an item.

### arrows

boolean, Default: true

Shows Prev/Next arrows.

### centerMode

boolean, Default: false

Enables centered view with partial prev/next slides.

### centerPadding

String, Default: 50px

Side padding when in center mode, in pixels or percentage.

### cssEase

String, Default: ease

CSS3 easing function name.

### dots

boolean, Default: false

Show dotted indicators at the bottom of the slider.

### fade

boolean, Default: false

Enables fade effects for transitioning between slides.

### focusOnSelect

boolean, Default: false

Go to slide on click.

### infinite

boolean, Default: true

Enables infinite looping of slides.

### initialSlide

integer, Default: 0

Index of the initial slide to display.

### lazyLoad

String, Default: ondemand

Enumerations: ondemand, progressive

Delays loading of images. Options: 'ondemand', 'progressive'.

### pauseOnHover

boolean, Default: true

Pauses autoplay when the carousel is hovered over.

### slidesToShow

integer, Default: 1

Number of slides to show at a time.

### slidesToScroll

integer, Default: 1

Number of slides to scroll at a time.

### speed

integer, Default: 500

Transition speed in milliseconds.

### swipe

boolean, Default: true

Enables swipe functionality for touch devices.

### vertical

boolean, Default: false

Enables vertical sliding mode.

### rows

integer, Default: 1

Number of rows per slide in the slider's grid.

### slidesPerRow

integer, Default: 1

Number of slides to display in each row of the grid.

### variableWidth

boolean, Default: false

Variable width for each slide in the carousel.

### rtl

boolean, Default: false

Changes the carousel's direction to right-to-left.

# Chart

Allows the generation of charts from data

## Properties

### variant

String

Enumerations: LineBasic, LineSmooth, LineStep, AreaBasic, AreaSmooth, AreaStep, AreaStacked, BarsBasicVertical, BarsChiseledVertical, BarsStackedVertical, BarsStacked100Vertical, BarsProfitLossVertical, BarsBasicHorizontal, BarsStackedHorizontal, BarsStacked100Horizontal, BarsProfitLossHorizontal, Timeline, RangeArea, CandleStick, Donut, Pie

chart type

### lineStyle

String

Enumerations: straight, smooth, stepline

Style of line charts

### sparkLines

boolean

if set true, Sparkline hides all the elements of the charts other than the primary paths. Helps to visualize data in small areas

### lineMarkers

integer

if set a value above 0, markers will be placed at data points

### lineWidth

integer

override for the linewidth

### zoomEnabled

boolean

whether or not zoom is enabled on this chart

### dataLabelsEnabled

boolean

whether or not data labels are enabled

### sql

String

optional, if set we will SQL query client side tables and graph the answer

### autoRefreshMs

integer

if set, chart will auto refresh (sql etc) this many MS (should be >3000)

### labels

stringlist

if set, will be labels for the data fields

### fieldNames

stringlist

If given an array of arrays, fieldNames holds each column name

### options

String

alt method of setting chart options via specific json object

### yAxis

String

alt method of setting yAxis options via specific json object

### xAxis

String

alt method of setting xAxis options via specific json object

### title

String

Chart title

### tooltipSpec

String

alt method of setting tooltip options via specific json object

### annotations

String

alt method of setting annotations options via specific json object

### plotOptions

String

alt method of setting plotOptions options via specific json object

### yAxis

String

alt method of setting yAxis options

### maxUpdateMs

integer

restricts the chart to only update at maximum every maxUpdateMs

### yTitle

String

text to place on the y Axis

### yMin

double

optional minimum y value on chart

### yMax

double

optional maximum y value on chart

### stacked

boolean

activate stacked chart mode

### dataLabelFormat

String

sprintf format for data labels

### yAxisFormat

String

sprintf format for y axis labels

### xAxisFormat

String

sprintf format for x axis labels

# ChartEx

Allows the generation of charts from data

## Properties

### type

String

Enumerations: Line, Bar, Pie, Donut, StackedBar, HorizontalBar, StackedHorizontalBar

chart type

### sql

String

optional, if set we will SQL query client side tables and graph the answer

### labels

stringlist

if set, will be labels for the data fields

### legends

stringlist

if set, will be length for the various fields

### colors

stringlist

if set, will be used for color overrides.  By default preset chart colors are theme.chart.a, chart.b etc from theme

### legendPos

String

Enumerations: north, west, east, south

where the legend should be positioned

### chartPadding

any, Default: {top: 15, right: 15, bottom: 5, left: 10}

The amount of padding to add around the chart. Can be a single number (applied to all sides) or an object with 'top', 'right', 'bottom', 'left' properties.

### high

double

The highest value that will be shown on the chart.

### low

double

The lowest value that will be shown on the chart.

### scaleMinSpace

double

This option will be used when finding the right scale division settings. The amount of ticks on the scale will be determined so that as many ticks as possible will be displayed, while not violating this minimum required space (in pixel)

### onlyInteger

boolean

If set to true, the scale will be generated with whole numbers only.

### referenceValue

Double

The reference value can be used to make sure that this value will always be on the chart.

### divisor

integer, Default: 1

If specified then the value range determined from minimum to maximum (or low and high) will be divided by this number and ticks will be generated at those division points

### ticks

any

If ticks is explicitly set, then the axis will not compute the ticks with the divisor, but directly use the data in ticks to determine at what points on the axis a tick need to be generated.

### showArea

boolean, Default: false

Whether or not to fill in the area below the line on a line chart.

### showPoint

boolean, Default: true

Whether or not to show points on the line of a line chart.

### showLine

boolean, Default: true

Whether or not to show the line on a line chart.

### fullWidth

boolean, Default: false

If set to true, the chart will take up the full width of its parent container.

### axisX

any, Default: {}

An object containing options for the x-axis.

### axisY

any, Default: {}

An object containing options for the y-axis.

### reverseData

boolean, Default: false

Reverse the order of the data arrays.

### lineSmooth

any, Default: true

Determines whether lines should be smoothed. Can be a boolean or a smoothing function.

### seriesBarDistance

double, Default: 15

The distance between bars in a bar chart.

### distributeSeries

boolean, Default: false

If set to true, will evenly distribute values over the chart in a bar or line chart.

### donutWidth

double

The width of the donut chart ring.

### startAngle

double, Default: 0

The starting angle of the pie or donut chart.

### total

double

The total value that the pie or donut chart should represent.

### showLabel

boolean, Default: true

If set to false, labels will be hidden.

### stretch

boolean, Default: false

If set to true, will force the chart to use all available space by stretching.

### ignoreEmptyValues

boolean, Default: false

If set to true, empty values will be ignored to avoid drawing unecessary elements.

### reverseData

boolean, Default: false

If set to true, the data series order will be reversed.

# Checkbox

A checkbox is a graphical control element that allows for multiple options to be selected or deselected by the user. It is often used to represent boolean values, such as on/off or true/false, in a user interface. Users might choose to use a checkbox to allow users to select one or more options from a list of choices.

## Properties

### aria-label

String

Defines the string that labels the checkbox element.

### aria-labelledby

String

Refers to the `id` of the element that labels the checkbox element.

### icon

icon, Default:

The checked icon to use

### iconColor

String

The color of the checkbox icon when checked or indeterminate

### iconSize

any

The size of the checkbox icon when checked or indeterminate

### iconBgColor

String

Icon ba

### isFocusable

boolean, Default: false

If `true` and `isDisabled` is passed, the checkbox willremain tabbable but not interactive

### isIndeterminate

boolean, Default: false

If `true`, the checkbox will be indeterminate.This only affects the icon shown inside checkboxand does not modify the isChecked property.

### isInvalid

boolean, Default: false

If `true`, the checkbox is marked as invalid.Changes style of unchecked state.

### isReadOnly

boolean, Default: false

If `true`, the checkbox will be readonly

### isRequired

boolean, Default: false

If `true`, the checkbox input is marked as required,and `required` attribute will be added

### spacing

any, Default: 0.5rem

The spacing between the checkbox and its label text

### tabIndex

String

The tab-index property of the underlying input element.

### value

boolean

The value to be used in the checkbox input.This is the value that will be returned on form submission.

### variant

String

The variant of the Checkbox

### isNative

boolean, Default: false

If `true`, input elements will receive`checked` attribute instead of `isChecked`.This assumes, you're using native radio inputs

# CheckboxGroup

CheckboxGroup speeds up quickly creating a number of different checkbox options
Text attribute takes a comma separated list of checkbox names to add.
getValue returns array of which values are set.
setValue either takes a comma separated list of items to check, or a string array

## Properties

### aria-label

String

Defines the string that labels the checkbox element.

### aria-labelledby

String

Refers to the `id` of the element that labels the checkbox element.

### icon

icon, Default:

The checked icon to use

### iconColor

String

The color of the checkbox icon when checked or indeterminate

### iconSize

any

The size of the checkbox icon when checked or indeterminate

### iconBgColor

String

Icon ba

### isFocusable

boolean, Default: false

If `true` and `isDisabled` is passed, the checkbox willremain tabbable but not interactive

### isIndeterminate

boolean, Default: false

If `true`, the checkbox will be indeterminate.This only affects the icon shown inside checkboxand does not modify the isChecked property.

### isInvalid

boolean, Default: false

If `true`, the checkbox is marked as invalid.Changes style of unchecked state.

### isReadOnly

boolean, Default: false

If `true`, the checkbox will be readonly

### isRequired

boolean, Default: false

If `true`, the checkbox input is marked as required,and `required` attribute will be added

### spacing

any, Default: 0.5rem

The spacing between the checkbox and its label text

### tabIndex

String

The tab-index property of the underlying input element.

### value

stringlist

The value to be used in the checkbox input.This is the value that will be returned on form submission.

### variant

String

The variant of the Checkbox

### isNative

boolean, Default: false

If `true`, input elements will receive`checked` attribute instead of `isChecked`.This assumes, you're using native radio inputs

# CheckboxIcon

CheckboxIcon is a UI component that displays a customizable checkbox with an accompanying icon. It allows users to select or deselect an option and provides visual feedback. It could be beneficial for web developers who want to design interactive user interfaces with checkboxes and icons.

## Properties

### aria-label

String

Defines the string that labels the checkbox element.

### aria-labelledby

String

Refers to the `id` of the element that labels the checkbox element.

### icon

icon, Default:

The checked icon to use

### iconColor

String

The color of the checkbox icon when checked or indeterminate

### iconSize

any

The size of the checkbox icon when checked or indeterminate

### iconBgColor

String

Icon ba

### isFocusable

boolean, Default: false

If `true` and `isDisabled` is passed, the checkbox willremain tabbable but not interactive

### isIndeterminate

boolean, Default: false

If `true`, the checkbox will be indeterminate.This only affects the icon shown inside checkboxand does not modify the isChecked property.

### isInvalid

boolean, Default: false

If `true`, the checkbox is marked as invalid.Changes style of unchecked state.

### isReadOnly

boolean, Default: false

If `true`, the checkbox will be readonly

### isRequired

boolean, Default: false

If `true`, the checkbox input is marked as required,and `required` attribute will be added

### spacing

any, Default: 0.5rem

The spacing between the checkbox and its label text

### tabIndex

String

The tab-index property of the underlying input element.

### value

boolean

The value to be used in the checkbox input.This is the value that will be returned on form submission.

### variant

String

The variant of the Checkbox

### isNative

boolean, Default: false

If `true`, input elements will receive`checked` attribute instead of `isChecked`.This assumes, you're using native radio inputs

# CircularProgress

The CircularProgress control displays a circular progress bar that indicates the current progress of an ongoing task. It can be customized with a color, size, and thickness of the progress bar. Using the CircularProgress control provides a visually appealing and informative way to show the progress of a task to users.

## Properties

### capIsRound

boolean, Default: false

If `true`, the cap of the progress indicator will be rounded.

### color

String

The color of the progress indicator. Use a color key in the theme object

### size

Object

Set the size of the circular progress component

### getValueText

String

A function that returns the desired valueText to use in place of the value

### isIndeterminate

boolean, Default: false

If `true`, the progress will be indeterminate and the `value`prop will be ignored

### max

double, Default: 100

Maximum value defining 100% progress made (must be higher than 'min')

### min

double, Default: 0

Minimum value defining 'no progress' (must be lower than 'max')

### thickness

any, Default: 10px

This defines the stroke width of the svg circle.

### trackColor

String

The color name of the progress track. Use a color key in the theme object

### value

double

Current progress (must be between min/max)

### valueText

String

The desired valueText to use in place of the value

### hasStripe

boolean, Default: false

If `true`, the progress bar will show stripe

### isAnimated

boolean, Default: false

If `true`, and hasStripe is `true`, the stripes will be animated

### variant

String

The variant of the Progress

# CircularProgressLabel

The CircularProgressLabel is a circular progress bar with a label at its center that shows the current progress as a percentage. It's used to display the progress of a task or operation visually.

## Properties

### capIsRound

boolean, Default: false

If `true`, the cap of the progress indicator will be rounded.

### color

String

The color of the progress indicator. Use a color key in the theme object

### getValueText

String

A function that returns the desired valueText to use in place of the value

### isIndeterminate

boolean, Default: false

If `true`, the progress will be indeterminate and the `value`prop will be ignored

### max

double, Default: 100

Maximum value defining 100% progress made (must be higher than 'min')

### min

double, Default: 0

Minimum value defining 'no progress' (must be lower than 'max')

### thickness

any, Default: 10px

This defines the stroke width of the svg circle.

### trackColor

String

The color name of the progress track. Use a color key in the theme object

### value

String

Current progress (must be between min/max)

### valueText

String

The desired valueText to use in place of the value

### hasStripe

boolean, Default: false

If `true`, the progress bar will show stripe

### isAnimated

boolean, Default: false

If `true`, and hasStripe is `true`, the stripes will be animated

### variant

String

The variant of the Progress

# CloseButton

The CloseButton control is a small button that allows users to close or dismiss a component or modal window with a single click. It is often used for user interface elements that require a quick and easy way to close or dismiss them.

## Properties

### variant

String

The variant of the CloseButton

# Code

Code control is a user interface component that allows users to display and render code snippets with syntax highlighting and line numbering features. This component is commonly used in software development and programming environments to display code samples and examples, making it easier for users to read and understand complex code blocks. Users might use this control to simplify the visualization of code samples and make them more accessible and understandable.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Collapse

The Collapse control allows users to collapse and expand content, such as text, images, or entire sections of a website, in a clean and organized way, saving space and minimizing clutter. It is useful for presenting information in a concise manner and improving user experience by allowing them to focus on relevant information.

## Properties

### animateOpacity

boolean, Default: true

If `true`, the opacity of the content will be animated

### delay

String

Custom `delay` definition for `enter` and `exit`

### endingHeight

any, Default: auto

The height you want the content in its expanded state.

### in

boolean

Show the component; triggers when enter or exit states

### startingHeight

any, Default: 0

The height you want the content in its collapsed state.

### transition

String

Custom `transition` definition for `enter` and `exit`

### transitionEnd

String

Custom `transitionEnd` definition for `enter` and `exit`

### unmountOnExit

boolean

If `true`, the element will unmount when `in={false}` and animation is done

### initialScale

String, Default: 0.95

The initial scale of the element

### reverse

boolean, Default: true

If `true`, the element will transition back to exit state

### offsetX

any, Default: 0

The offset on the horizontal or `x` axis

### offsetY

any, Default: 8

The offset on the vertical or `y` axis

# ColorModeProvider

ColorModeProvider is a component that manages the color mode of an application by providing a ThemeProvider with the specified color mode. It allows users to switch between light and dark mode in an application.

It allows users to control the appearance of their application by providing a simple, built-in way to manage the color mode.

## Properties

# ColorModeScript

The ColorModeScript control is a component that dynamically switches the color mode of a website based on the user's preference or system settings. It simplifies the process of implementing a dark mode or light mode theme for a website. It allows users to customize their website viewing experience and reduce eye strain in low-light settings.

## Properties

# CompassBox

This creates a Box where children can be added north south east west center using ContainerPosition

## Properties

# ComponentBox

This creates a Box which loads a component of a given name and displays it within page

## Properties

### controlName

String

name of the control to include

### controlInfo

String

optional info for a particular style etc of the control.  This is optionally parsed by the factory

# ControlBox

The ControlBox control is a component that allows users to create custom checkboxes and radio buttons with ease. It provides various customizable options such as size, color, and shape, making it an efficient tool for creating a consistent UI. Overall, the ControlBox control can significantly improve the user experience by offering a clear and intuitive way of selecting options among a list.

## Properties

# DashboardLayout

Dashboard with NSEWCentral grid layout

## Properties

### eastWidth

any

width of the east area

### westWidth

any

width of the west area

### headerHeight

any

height of the header area

### footerHeight

any

height of the footer area

### gap

integer

gap between areas

# DatePicker

Component that allows selecting the date

## Properties

### minDate

Object

optional minimum date - can be long  ms, or string YYYY-MM-DD

### maxDate

Object

optional maximum date - can be long  ms, or string YYYY-MM-DD

### hasTime

boolean

if true, time picker is included

# DbTable

Allows the setting up of Datatables on the client side, which can be viewed used.  Loaded from server. Set value to RecordStorage

## Properties

### tableName

String

name of the table

### value

IRecordStorage

name of the table

### tableCreation

String

optional sql statement to create the table at startup - system will auto generate table from data if none given

### columnIndexes

stringlist

optional list of columns to add indexes to on the table

### dataJsonUrl

String

if set, url to read JSON data from.  Expects json array of objects as reply

### dataSql

String

if set, data will be loaded from sql - e.g. from other tables

### reloadMs

integer

if set, we will attempt reload data from data source every X ms

# DisplayList

A List control is a user interface element that displays a vertical or horizontal list of items, which can contain text, images, or other types of content. Each item is typically clickable, and may trigger an action or navigation to another part of the application.

One might use a List control to display a series of related items, such as a list of menu options, messages in a chat app, or products in an online store. This can make it easier for users to navigate and interact with the content, without having to scroll through long pages or menus.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Divider

The Divider control is a component that adds a horizontal or vertical line to visually separate content on a webpage or application. It can be used to organize information and create clear distinctions between sections.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

### orientation

String

Enumerations: horizontal, vertical

orientation of the divider

# Drawer

The Drawer control is a component that displays a panel on the screen that can be opened and closed using a button or gesture. It is commonly used to display secondary navigation, settings, or additional information without taking up valuable screen real estate.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# DrawerContent

The DrawerContent control is a component that provides a slide-out menu that can be used to display additional content or navigation options. It is often used in mobile or responsive layouts to conserve screen space while still providing access to important features.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# EChart

A versatile charting component based on ECharts that supports multiple chart types and configurations for complex data visualization.

## Properties

### optionsJson

String

If set, contains a json string containing the default options to apply to the chart

### dimensions

Object

If set, contains ordering of dimensions

### title

Object

Configures the chart title, supporting both single and multiple titles.

### tooltip

Object

Options for the tooltip that appears when hovering over chart elements.

### legend

Object

Settings for the chart legend, allowing single or multiple legends.

### grid

Object

Specifies the grid properties for the chart layout.

### xAxis

Object

Configuration options for the horizontal axis of the chart.

### yAxis

Object

Configuration options for the vertical axis of the chart.

### series

List

Series data for the chart, supporting multiple types like bar, line, pie, etc.

### dataset

Object

Provides a description of the data to be used in the chart.

### toolbox

Object

Tools for the chart, such as saving, restoring, or changing chart type.

### dataZoom

List

Components to enable zooming and panning on parts of the chart.

### visualMap

Object

A component to visually map the data to colors.

### axisPointer

Object

Configures pointers like crosshair on axes.

### timeline

Object

Options for adding a timeline to the chart for temporal data visualization.

### graphic

List

Custom graphic elements that can be added to the chart.

### geo

Object

Geographical component options for making geo-related charts.

### categories

List

Categories for differentiating data in charts under specific configurations.

# Editable

The Editable control is a component that allows a read only view, and editable view. It enables users to easily modify content directly on a web page, which facilitates a better user experience. Its use is ideal for applications that require frequent updates or changes in content.

## Properties

### editButtonText

String

The default button that will be shown - onclick starts editing.  If empty, clicking on preview starts editing

### isPreviewFocusable

boolean, Default: true

If `true`, the read only view, has a `tabIndex` set to `0`so it can receive focus via the keyboard or click.

### editIcon

icon

Picture to use to edit change

### acceptIcon

icon

Picture to use to accept change

### cancelIcon

icon

Picture to use to cancel change

### placeholder

String

The placeholder text when the value is empty.

### selectAllOnFocus

boolean, Default: true

If `true`, the input's text will be highlighted on focus.

### startWithEditView

boolean

If `true`, the Editable will start with edit mode by default.

### submitOnBlur

boolean, Default: true

If `true`, it'll update the value onBlur and turn off the edit mode.

### value

String

The value of the Editable in both edit & preview mode

# EditablePreview

The EditablePreview control is a component that allows users to edit a piece of text within a preview, enabling easy inline editing and customization of the content. It provides a seamless way to edit text in real-time, and users can easily preview the changes they make. Users would use it to save time by quickly editing text without the need to switch between a preview and edit mode.

## Properties

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### isPreviewFocusable

boolean, Default: true

If `true`, the read only view, has a `tabIndex` set to `0`so it can receive focus via the keyboard or click.

### placeholder

String

The placeholder text when the value is empty.

### selectAllOnFocus

boolean, Default: true

If `true`, the input's text will be highlighted on focus.

### startWithEditView

boolean

If `true`, the Editable will start with edit mode by default.

### submitOnBlur

boolean, Default: true

If `true`, it'll update the value onBlur and turn off the edit mode.

### value

String

The value of the Editable in both edit & preview mode

# EditableTextarea

The EditableTextarea control allows users to edit multi-line text within a GUI by clicking on it and typing directly into it. Its built-in functionality also allows for the saving of any changes made. It might be used in situations where a user needs to edit and save multi-line text quickly and efficiently within a larger application.

## Properties

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### isPreviewFocusable

boolean, Default: true

If `true`, the read only view, has a `tabIndex` set to `0`so it can receive focus via the keyboard or click.

### placeholder

String

The placeholder text when the value is empty.

### selectAllOnFocus

boolean, Default: true

If `true`, the input's text will be highlighted on focus.

### startWithEditView

boolean

If `true`, the Editable will start with edit mode by default.

### submitOnBlur

boolean, Default: true

If `true`, it'll update the value onBlur and turn off the edit mode.

### value

String

The value of the Editable in both edit & preview mode

# EnvironmentProvider

The EnvironmentProvider control is a component that allows for sharing environment variables across components. It provides a convenient way to pass down commonly used variables, such as API endpoints or authentication tokens, to child components. This can increase code reusability and simplify component logic.

## Properties

# Fade

The Fade control allows users to animate transitions between two states by gradually increasing or decreasing the opacity of an element. This can be useful for creating more visually appealing and dynamic user interfaces.

## Properties

### animateOpacity

boolean, Default: true

If `true`, the opacity of the content will be animated

### delay

String

Custom `delay` definition for `enter` and `exit`

### endingHeight

any, Default: auto

The height you want the content in its expanded state.

### in

boolean

Show the component; triggers when enter or exit states

### startingHeight

any, Default: 0

The height you want the content in its collapsed state.

### transition

String

Custom `transition` definition for `enter` and `exit`

### transitionEnd

String

Custom `transitionEnd` definition for `enter` and `exit`

### unmountOnExit

boolean

If `true`, the element will unmount when `in={false}` and animation is done

### initialScale

String, Default: 0.95

The initial scale of the element

### reverse

boolean, Default: true

If `true`, the element will transition back to exit state

### offsetX

any, Default: 0

The offset on the horizontal or `x` axis

### offsetY

any, Default: 8

The offset on the vertical or `y` axis

# Flex

The Flex control is a CSS layout property that allows for flexible positioning and sizing of elements within a container, allowing for responsive design and dynamic layouts. It is useful for creating complex and adaptable user interfaces.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# FocusLock

FocusLock control is a feature that restricts the focus of the user to a particular element on the web page, preventing them from interacting with other elements until the task is completed. It helps in maintaining user flow and improving accessibility. Someone might use it to improve the user experience on their website/app.

## Properties

### autoFocus

boolean, Default: false

If `true`, the first focusable element within the `children`will auto-focused once `FocusLock` mounts

### contentRef

String

The `ref` of the wrapper for which the focus-lock wraps

### finalFocusRef

String

`ref` of the element to return focus to when `FocusLock`unmounts

### initialFocusRef

String

`ref` of the element to receive focus initially

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### persistentFocus

boolean, Default: false

If `true`, disables text selections inside, and outside focus lock

### restoreFocus

boolean, Default: false

If `true`, focus will be restored to the element thattriggered the `FocusLock` once it unmounts

# FormContext

A method of sharing data between controls inside this container.  Any control with name set will have its data replicated here.  Additionally, multiple components having the same name will have their values auto-synced.

## Properties

### value

dictionary

Returns a map which contains the named values of all controls inside this container

# FormErrorMessage

The FormErrorMessage control is a component that displays an error message for a form field when invalid input is submitted. It helps users understand why their input was not accepted and how to correct it. It is useful for improving the user experience and reducing confusion around form submissions.

## Properties

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### label

String

The label text used to inform users as to what information isrequested for a text field.

# FormHelperText

FormHelperText is a user interface control that displays helpful information or error messages related to input fields in a form. It is typically used to provide context or guidance to the user when filling out forms or submitting data.

## Properties

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### label

String

The label text used to inform users as to what information isrequested for a text field.

# FormInput

The FormControl control is a component that provides a wrapper around form controls such as input, textarea, and select. It allows for easier management of forms, including handling of values, events, and validation. One might use it to simplify the process of building and managing forms in a application.

## Properties

### placeholder

String

The placeholder text when the value is empty.

### errorText

String

Text that will be shown if the value within the control is in error (typically meaning value unset)

### validateFocusLeave

boolean, Default: false

if set, we only check the validation when controls inside are not focused

### validationRegex

any, Default: false

if set, the regex will validate the text of the values.  If fail (or no data) we are in error condition

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. Side effects:- errorText is shown for hint, the `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### text

String

Set the top label text used to inform users as to what information is requested for a text field.

### helperText

String

The label text used to inform users as to what information isrequested for a text field.

### namePosition

String, Default: west

Enumerations: west, north

The label text used to inform users as to what information isrequested for a text field.

# FormLabel

The FormLabel control is a UI component that serves as a label for an input field in a form. It allows developers to associate a label with its corresponding input field, making the form more accessible and user-friendly. Its usage helps to improve the overall usability of a form.

## Properties

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### label

String

The label text used to inform users as to what information isrequested for a text field.

# Grid

The Grid control is a layout system that allows users to organize content into columns and rows. It enables users to create responsive and flexible websites that look great on different devices. It saves time and effort in designing and managing layouts.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# GridItem

The GridItem control allows you to create a flexible grid layout by defining the placement and sizing of individual items within the grid. It is useful for creating complex, responsive designs with a consistent look and feel.

## Properties

### area

String

row-start / column-start / row-end / column-end

### colStart

integer

column start

### colEnd

integer

column end

### rowStart

integer

row start

### rowEnd

integer

row end

### rowSpan

integer

number of rows in height

### colSpan

integer

number of cols in width

# GridLayout

Used for creating dynamic, responsive grid layouts in React, providing various options to adjust layout behaviour

## Properties

### width

integer

Container width used for calculating the grid

### autoSize

boolean

If true, the container height will be set to the height of the contents

### cols

integer

Number of columns in this layout

### draggableCancel

String

A CSS selector for tags that will not be draggable

### draggableHandle

String

A CSS selector for tags that will act as the draggable handle

### compactType

String

Enumerations: none, vertical, horizontal

Compaction type

### layout

dictionary

Layout is an array of objects with the format {x: integer, y: integer, w: integer, h: integer}

### margin

intlist

Margin between items [x, y] in px

### containerPadding

intlist

Padding inside the container [x, y] in px

### rowHeight

integer

The height of a row in pixels

### isDraggable

boolean

If set to false, grid items will not be draggable

### isResizable

boolean

If set to false, grid items will not be resizable

### isBounded

boolean

If set to true, grid items will be bounded by the layout container

### useCSSTransforms

boolean

If true, CSS transforms will be used for position and size updates

### transformScale

integer

The scale coefficient for CSS transforms

### allowOverlap

boolean

If true, grid items can be placed one over the other

### preventCollision

boolean

If set to true, collisions will be prevented when dragging and resizing

### isDroppable

boolean

If true, droppable elements can be dropped on the grid

### resizeHandles

stringlist

Defines which resize handles should be rendered 's' | 'w' | 'e' | 'n' | 'sw' | 'nw' | 'se' | 'ne'

### onLayoutChange

function

Callback function that is called after a layout change

### onDragStart

function

Callback function that is called when drag starts

### onDrag

function

Callback function that is called on each drag movement

### onDragStop

function

Callback function that is called when drag is complete

### onResizeStart

function

Callback function that is called when resize starts

### onResize

function

Callback function that is called when resize movement happens

### onResizeStop

function

Callback function that is called when resize is complete

### onDrop

function

Callback function that is called when an element has been dropped into the grid from outside

### onDropDragOver

function

Callback function that is called when an element is being dragged over the grid from outside

# GridWindow

Used for creating a bordered themed window, which can be moved on a GridLayout and resized

## Properties

### width

integer

Container width used for calculating the grid

### height

integer

If true, the container height will be set to the height of the contents

### scaleWidthPx

integer

if set/not null, the contents will be rendered at this width, then scaled to the window size

### scaleHeightPx

integer

if set/not null, the contents will be rendered at this height, then scaled to the window size

### x

integer

x position of the window

### y

integer

y position of the window

### header

boolean

show header

### draggable

boolean

allow window to be dragged

### resizeable

boolean

allow window to be resized

### border

String

Type of border, e.g 1px solid lightgray

# GroupTable

Grouping Table control

## Properties

### columns

any

list of ColumnDefinitions

### grouping

stringlist

list of columns to group on the table

### tableName

String

if set, we will use the client table of this name as a data source

### minUpdateRateMs

integer

if set, every X ms we will force an update of the control data (if not paused)

### maxUpdateRateMs

integer

if set, we will limit our updates to this often, e.g. 1000 == 1 update max per second

# HStack

Horizontal stacking component

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Heading

The Heading control is a component that allows you to easily create styled headings for your web application. It provides a range of preset styles and sizes, and enables you to customize the color and font of your heading text. It can be used to improve the readability and visual appeal of your website's titles and headings.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Heartbeat

Client sends a localtime value to the server every X seconds.  LocalTime string. ISoString + timezone

## Properties

### heartbeatInterval

integer, Default: 15

number of seconds between heartbeat

# Hide

The Hide control is a feature that allows users to hide certain elements or components within a web application. It is typically used to improve the user experience by removing clutter or irrelevant information from a page. One might use it to enhance the usability and visual appeal of their website.

## Properties

### above

String

A value from the `breakpoints` section in the theme. Will render `children`from that breakpoint and above. Default breakpoint values: `sm`, `md`, `lg`, `xl`, `2xl`.

### below

String

A value from the `breakpoints` section in the theme. Will render `children`from that breakpoint and below. Default breakpoint values: `sm`, `md`, `lg`, `xl`, `2xl`.

### breakpoint

String

A custom css media query that determines when the `children` are rendered.Will render `children` if that query resolves to `true`.

# Highlight

The Highlight control allows users to specify a specific area or element of a webpage to be visually highlighted. It can help draw attention to important information or make it easier to locate a certain section on a page. Users might use it to improve the user experience of their website or optimize it for accessibility purposes.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# IFrame

Inserts an IFrame with a src flag

## Properties

### title

String

title of the iframe

### src

String

source of the iframe

### allowFullScreen

boolean

flag to allow full screen

### allowPaymentRequest

boolean

iframe allowpaymentrequest

### loading

String

null

### referrerpolicy

String

null

### sandbox

String

null

### srcdoc

String

null

# Icon

The Icon control allows developers to easily display icons from popular icon libraries within their web applications. It provides a simple way to access and integrate icons into various components and UI elements. This can be helpful for creating a visually appealing interface with minimal effort.

## Properties

### icon

icon, Default:

The checked icon to use

### iconColor

String

The color of the checkbox icon when checked or indeterminate

### iconSize

any

The size of the checkbox icon when checked or indeterminate

### iconBgColor

String

Icon ba

# IconButton

IconButton is a control that displays an icon and allows users to click or tap it to trigger an action. It's useful for providing a clear and easy-to-use interface for actions like saving, sharing, or deleting.

## Properties

### iconSpacing

any

The space between the button icon and label.

### isActive

boolean, Default: false

If `true`, the button will be styled in its active state.

### isLoading

boolean, Default: false

If `true`, the button will show a spinner.

### leftIcon

icon

If added, the button will show an icon before the button's label.

### loadingText

any

The label to show in the button when `isLoading` is trueIf no text is passed, it only shows the spinner

### rightIcon

icon

If added, the button will show an icon after the button's label.

### spinner

icon

Replace the spinner component when `isLoading` is set to `true`

### spinnerPlacement

String, Default: start

Enumerations: start, end

It determines the placement of the spinner when isLoading is true

### variant

String, Default: solid

Enumerations: ghost, outline, solid, link, unstyled

The variant of the Button

### isAttached

boolean, Default: false

If `true`, the borderRadius of button that are direct children will be alteredto look flushed together

### spacing

any, Default: '0.5rem'

The spacing between the buttons

### aria-label

String

A11y: A label that describes the button

### icon

icon

The icon to be used in the button.

### isRound

boolean, Default: false

If `true`, the button will be perfectly round. Else, it'll be slightly round

# Image

The Image control is a user interface element that displays an image on a webpage or application. It can be customized with various attributes such as alternative text, width, height, and position. This control is useful for showcasing visual content to users.

## Properties

### crossOrigin

String

Enumerations: , anonymous, use-credentials

The key used to set the crossOrigin on the HTMLImageElement into which the image will be loaded.This tells the browser to request cross-origin access when trying to download the image data.

### fallback

icon

Fallback element to show if image is loading or image fails.

### fallbackSrc

String

Fallback image `src` to show if image is loading or image fails.Note 🚨: We recommend you use a local image

### fallbackStrategy

String, Default: beforeLoadOrError

- beforeLoadOrError(default): loads the fallbackImage while loading the src- onError: loads the fallbackImage only if there is an error fetching the src

### fit

enum

How the image to fit within its bounds.It maps to css `object-fit` property.

### htmlHeight

any

The native HTML `height` attribute to the passed to the `img`

### htmlWidth

any

The native HTML `width` attribute to the passed to the `img`

### ignoreFallback

boolean, Default: false

If `true`, opt out of the `fallbackSrc` logic and use as `img`

### sizes

String

The image `sizes` attribute

### src

String

The image `src` attribute

### srcSet

String

The image `srcset` attribute

### loading

String

Enumerations: eager, lazy

'eager' | 'lazy'

# ImageButton

The Image control is a user interface element that displays an image on a webpage or application. It can be customized with various attributes such as alternative text, width, height, and position. This control is useful for showcasing visual content to users.

## Properties

### crossOrigin

String

Enumerations: , anonymous, use-credentials

The key used to set the crossOrigin on the HTMLImageElement into which the image will be loaded.This tells the browser to request cross-origin access when trying to download the image data.

### fallback

icon

Fallback element to show if image is loading or image fails.

### fallbackSrc

String

Fallback image `src` to show if image is loading or image fails.Note 🚨: We recommend you use a local image

### fallbackStrategy

String, Default: beforeLoadOrError

- beforeLoadOrError(default): loads the fallbackImage while loading the src- onError: loads the fallbackImage only if there is an error fetching the src

### fit

enum

How the image to fit within its bounds.It maps to css `object-fit` property.

### htmlHeight

any

The native HTML `height` attribute to the passed to the `img`

### htmlWidth

any

The native HTML `width` attribute to the passed to the `img`

### ignoreFallback

boolean, Default: false

If `true`, opt out of the `fallbackSrc` logic and use as `img`

### sizes

String

The image `sizes` attribute

### src

String

The image `src` attribute

### srcSet

String

The image `srcset` attribute

### loading

String

Enumerations: eager, lazy

'eager' | 'lazy'

# Img

The Img control is an HTML image element that displays image content on a web page. It allows you to specify the image source URL and provides optional properties to set alternative text, width, height, and styling. It is commonly used to show visual content in a webpage.

## Properties

### crossOrigin

String

Enumerations: , anonymous, use-credentials

The key used to set the crossOrigin on the HTMLImageElement into which the image will be loaded.This tells the browser to request cross-origin access when trying to download the image data.

### fallback

icon

Fallback element to show if image is loading or image fails.

### fallbackSrc

String

Fallback image `src` to show if image is loading or image fails.Note 🚨: We recommend you use a local image

### fallbackStrategy

String, Default: beforeLoadOrError

- beforeLoadOrError(default): loads the fallbackImage while loading the src- onError: loads the fallbackImage only if there is an error fetching the src

### fit

enum

How the image to fit within its bounds.It maps to css `object-fit` property.

### htmlHeight

any

The native HTML `height` attribute to the passed to the `img`

### htmlWidth

any

The native HTML `width` attribute to the passed to the `img`

### ignoreFallback

boolean, Default: false

If `true`, opt out of the `fallbackSrc` logic and use as `img`

### sizes

String

The image `sizes` attribute

### src

String

The image `src` attribute

### srcSet

String

The image `srcset` attribute

# Input

The Input control is a user interface element that allows users to input and edit text or numerical data.  It could be used to create forms for data collection or search bars for filtering information.

## Properties

### type

String

Enumerations: color, date, datetime-local, email, hidden, image, month, number, password, search, tel, time, url, week

Optional input stylings

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputAddon

The InputAddon control is a component that allows the user to add an icon or text to an input field. It can be used to provide additional information or context, or to add a decorative element to the input field.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputElement

The InputElement control is a form input component that allows users to input and edit single line text. It supports various types of input fields, such as text, email, password, number, and more. It also provides flexibility in styling and handling events. It can be used to create user input forms for various purposes.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputGroup

InputGroup is a component in a user interface that groups together related form elements like an input field and a button. Its purpose is to provide a convenient and organized way to input data into a form.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputLeftAddon

InputLeftAddon is a component that allows you to add an element to the left side of an input field. It can be used to provide context or additional information related to the input field.

It can be useful in scenarios where a user needs to provide input in a specific format or context, such as entering a phone number with a country code.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputLeftElement

The InputLeftElement control is a UI component that allows users to add an icon or text on the left side of an input field. It is commonly used to show an icon or label that describes the input field, making it more accessible and user-friendly.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputRightAddon

The InputRightAddon control is a UI element that is attached to the right side of an input field. It is often used to display additional information or actions related to the input field, such as search buttons or icons, currency symbols, or measurement units. It provides a streamlined and easily accessible way for users to interact with and control the input.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# InputRightElement

InputRightElement is a component that allows you to add an element on the right side of an input field. This can be used to display additional information or functionality related to the input field, such as a search button or a clear button. It can improve the usability and accessibility of a form by providing clear visual cues for the user.

## Properties

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### htmlSize

String

The native HTML `size` attribute to be passed to the `input`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Input

# Kbd

The Kbd control is an HTML element that renders text as if it were typed on a keyboard. It is used to display keyboard shortcuts or key combinations in a stylized manner, making them more visually appealing and easier to understand for users. Someone might use it to enhance the user experience by providing clear and concise instructions for keyboard shortcuts.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Link

The Link control allows users to create clickable links that navigate to a designated URL or location when clicked.

One might use it to provide easy and quick access to external resources or internal pages within the website or application.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# LinkBox

The LinkBox control is a clickable box that can contain various types of content such as text, images and icons. It's typically used to create clickable elements in a UI such as buttons, cards or tiles. Its main purpose is to provide a consistent and easily customizable way to create interactive UI elements.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# LinkOverlay

The LinkOverlay control is a component that overlays a hyperlink on top of another element in a web application. It allows users to interact with the link seamlessly without disrupting the layout or style of the surrounding content. It is an ideal solution for creating clickable elements that blend in with the existing design.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# ListItem

The ListItem control is a component that renders a single item in a list. It can be used to display information in an organized manner and allows for easy customization and styling of each individual item. Users might use this control to create lists of items in their web application or website.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Maps

A component for displaying interactive maps, including features such as markers, polylines, and various layers. Provides a visual geographical representation using tile layers as the base and allows for interactive additions such as markers and popups.

## Properties

### center

List<Double>

Specifies the initial geographic center of the map using latitude and longitude.

### zoom

integer, Default: 13

Determines the initial zoom level of the map.

### maxZoom

integer

Sets the maximum zoom level allowed on the map.

### minZoom

integer

Sets the minimum zoom level allowed on the map.

### zoomControl

boolean, Default: true

Determines whether the zoom control is displayed on the map.

### url

String

The URL template used to serve map tiles.

### attribution

String

A string defining the attribution text to be displayed on the map.

### position

List<Object>

Specifies the geographic location for placing a marker on the map. Takes Position/Circle/Polygon

### color

String

Sets the color of lines or borders of map shapes.

### fillColor

String

For shapes with an interior, sets their fill color.

### weight

integer

Sets the thickness of lines for borders of shapes and polylines.

### value

List<Position>

Main data for the map control, list of positions which are displayed as markers.

# Mark

The Mark control is a styled checkbox that allows users to select or deselect an option. It visually indicates the current selection status and can be used to toggle a state for an input field or group of related options.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Markdown

Component that allows rendering of text areas using markdown

## Properties

### controls

String

Enumerations: none, format, all

if active, many controls can be rendered using

# Menu

The Menu control is a component that displays a list of options in a dropdown menu. It allows users to navigate through different sections or perform various actions within an application. It can be used to improve the user experience and provide a clear and organized way for users to access specific functionalities.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuButton

The MenuButton control is a button component that displays a dropdown menu when clicked. It allows users to select one option from a list of choices. Its versatility and ease of use make it a great choice for any application that requires user input through a dropdown menu.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuCommand

The MenuCommand control is a graphical user interface element that represents a single command or action, typically displayed in a menu bar or dropdown menu. It allows users to interact with the application and execute specific tasks. It is commonly used in desktop applications and web-based software to provide a convenient way for users to access and execute frequently used actions.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuDivider

MenuDivider is a separator that can be added to navigation menus to visually separate groups of menu items. It helps improve visual hierarchy and navigation clarity in complex UIs.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuDrop

A pull down menu container, which contains MenuItems

## Properties

# MenuGroup

The MenuGroup control is a grouping component used to organize and display a collection of related items in a menu. It allows users to easily navigate through a list of options and helps to improve the user experience. This control is useful for creating dropdown menus or lists of complex items that need to be organized in a clear and concise way.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuItem

The MenuItem control allows developers to create clickable menu items with customizable styles and functionality, typically used in dropdown or context menus. It provides a convenient way to present a list of options for users to select from in a visually appealing and efficient manner.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuItemOption

The MenuItemOption control is used to render an individual clickable option within a dropdown menu. It allows users to select specific items from a list of options, providing a more user-friendly interface for selecting multiple values. Someone might use it to create a dropdown menu with selectable options in their web application.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuList

The MenuList control is a user interface component that presents a list of options for the user to choose from. It typically includes a dropdown menu with a list of items that the user can select. MenuList control can be used to provide a convenient way for users to access and navigate through different options or settings in an application.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# MenuOptionGroup

The MenuOptionGroup control is a component used for grouping MenuOptions together and managing their selection states. It allows for multiple options to be selected at once, or for only one option to be selected at a time. Users might use it to create a menu with selectable options that are visually grouped together.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# ModalBody

ModalBody is a component that displays the content within a modal dialog. It provides additional space for a user to view and interact with complex content that may be overwhelming or difficult to read otherwise. It is frequently used to improve user experience by breaking up information into smaller manageable chunks.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# ModalCloseButton

ModalCloseButton is a UI control that provides a button to close a modal dialog box. It is typically placed in the top-right corner of the modal. This control simplifies the process of adding a close button to a modal and provides a consistent user experience.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# ModalContent

ModalContent is a component for displaying content in a modal window, which appears on top of the rest of the screen and requires user interaction to dismiss it. It can be used to create a visually appealing and functional user interface that helps to improve the user experience by providing a focused view of the content.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# ModalDialog

Modal control is a user interface component that displays a popup window on top of the current screen to prompt an action or request input from the user. It allows users to engage with content without leaving the current page. It is commonly used to display alerts, confirmations, or inputs.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# ModalFooter

ModalFooter is a component that is used to render a footer in a modal dialog. It typically includes buttons that let users either submit or cancel the modal actions. It makes it easier to create a graceful and intuitive experience when a user interacts with a modal dialog.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# ModalHeader

The ModalHeader control is a UI component that provides a header section for modal dialogs. It typically includes a title and a close button, and may optionally include additional content such as a subtitle or icon. Using a ModalHeader helps ensure consistency and accessibility in modal dialogs, as well as providing a familiar and intuitive user experience for users.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# ModalOverlay

ModalOverlay is a control that creates a full-screen transparent overlay that can be used to display a modal dialog or message on top of existing content. It blocks user interaction with the underlying page or application until the modal is dismissed. It's useful for creating attention-grabbing notifications, informative pop-ups, and confirmations.

## Properties

### isOpen

boolean

If `true`, the modal will be open.

### allowPinchZoom

boolean, Default: false

Handle zoom/pinch gestures on iOS devices when scroll locking is enabled.

### autoFocus

boolean, Default: true

If `true`, the modal will autofocus the first enabled and interactiveelement within the `ModalContent`

### blockScrollOnMount

boolean, Default: true

If `true`, scrolling will be disabled on the `body` when the modal opens.

### closeOnEsc

boolean, Default: true

If `true`, the modal will close when the `Esc` key is pressed

### closeOnOverlayClick

boolean, Default: true

If `true`, the modal will close when the overlay is clicked

### finalFocusRef

String

The `ref` of element to receive focus when the modal closes.

### id

String

The `id` of the modal

### isCentered

boolean, Default: false

If `true`, the modal will be centered on screen.

### lockFocusAcrossFrames

boolean, Default: false

Enables aggressive focus capturing within iframes.- If `true`: keep focus in the lock, no matter where lock is active- If `false`:  allows focus to move outside of iframe

### motionPreset

String, Default: scale

The transition that should be used for the modal

### preserveScrollBarGap

boolean, Default: true

If `true`, a `padding-right` will be applied to the body elementthat's equal to the width of the scrollbar.This can help prevent some unpleasant flickering effectand content adjustment when the modal opens

### returnFocusOnClose

boolean, Default: true

If `true`, the modal will return focus to the element that triggered it when it closes.

### scrollBehavior

String, Default: outside

Where scroll behavior should originate.- If set to `inside`, scroll only occurs within the `ModalBody`.- If set to `outside`, the entire `ModalContent` will scroll within the viewport.

### trapFocus

boolean, Default: true

If `false`, focus lock will be disabled completely.This is useful in situations where you still need to interact withother surrounding elements.🚨Warning: We don't recommend doing this because it hurts theaccessibility of the modal, based on WAI-ARIA specifications.

### useInert

boolean, Default: true

A11y: If `true`, the siblings of the `modal` will have `aria-hidden`set to `true` so that screen readers can only see the `modal`.This is commonly known as making the other elements **inert**

### initialFocusRef

String

The `ref` of element to receive focus when the modal opens.

### isFullHeight

boolean

If `true` and drawer's placement is `top` or `bottom`,the drawer will occupy the viewport height (100vh)

### placement

String, Default: right

The placement of the drawer

### variant

String

The variant of the Drawer

# NavBarSimple

Resizing top of page bar.  Children positions EAST, CENTRE, WEST

## Properties

# NumberDecrementStepper

The NumberDecrementStepper control is a UI component that allows users to decrement a numeric value by a specified amount on each click of a decrement button. It is useful for instances where a numeric value needs to be adjusted in small increments.

## Properties

### allowMouseWheel

boolean

If `true`, the input's value will change based on mouse wheel

### clampValueOnBlur

boolean, Default: true

This controls the value update when you blur out of the input.- If `true` and the value is greater than `max`, the value will be reset to `max`- Else, the value remains the same.

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### focusInputOnChange

boolean, Default: true

If `true`, the input will be focused as you incrementor decrement the value with the stepper

### format

any

If using a custom display format, this converts the default format to the custom format.

### getAriaValueText

any

This is used to format the value so that screen readerscan speak out a more human-friendly value.It is used to set the `aria-valuetext` property of the input

### id

String

The `id` to use for the number input field.

### inputMode

any, Default: decimal

Hints at the type of data that might be entered by the user. It also determinesthe type of keyboard shown to the user on mobile devices

### isInvalid

boolean

If `true`, the input will have `aria-invalid` set to `true`

### isReadOnly

boolean

If `true`, the input will be in readonly mode

### isRequired

boolean

Whether the input is required

### isValidCharacter

boolean

Whether the pressed key should be allowed in the input.The default behavior is to allow DOM floating point characters defined by /^[Ee0-9+\-.]$/

### keepWithinRange

boolean, Default: true

This controls the value update behavior in general.- If `true` and you use the stepper or up/down arrow keys, the value will not exceed the `max` or go lower than `min`- If `false`, the value will be allowed to go out of range.

### max

double, Default: Number.MAX_SAFE_INTEGER

The maximum value of the counter

### min

double, Default: Number.MIN_SAFE_INTEGER

The minimum value of the counter

### parse

String

If using a custom display format, this converts the custom format to a format `parseFloat` understands.

### pattern

String, Default: [0-9]*(.[0-9]+)?

The pattern used to check the <input> element's value against on form submission.

### precision

integer

The number of decimal points used to round the value

### step

double, Default: 1

The step used to increment or decrement the value

### value

double

The value of the counter. Should be less than `max` and greater than `min`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the NumberInput

# NumberIncrementStepper

The NumberIncrementStepper control is a user interface component that allows users to increment or decrement a numerical value using buttons. It is commonly used in web or mobile applications where a numerical value needs to be adjusted by small increments or decrements.

## Properties

### allowMouseWheel

boolean

If `true`, the input's value will change based on mouse wheel

### clampValueOnBlur

boolean, Default: true

This controls the value update when you blur out of the input.- If `true` and the value is greater than `max`, the value will be reset to `max`- Else, the value remains the same.

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### focusInputOnChange

boolean, Default: true

If `true`, the input will be focused as you incrementor decrement the value with the stepper

### format

any

If using a custom display format, this converts the default format to the custom format.

### getAriaValueText

any

This is used to format the value so that screen readerscan speak out a more human-friendly value.It is used to set the `aria-valuetext` property of the input

### id

String

The `id` to use for the number input field.

### inputMode

any, Default: decimal

Hints at the type of data that might be entered by the user. It also determinesthe type of keyboard shown to the user on mobile devices

### isInvalid

boolean

If `true`, the input will have `aria-invalid` set to `true`

### isReadOnly

boolean

If `true`, the input will be in readonly mode

### isRequired

boolean

Whether the input is required

### isValidCharacter

boolean

Whether the pressed key should be allowed in the input.The default behavior is to allow DOM floating point characters defined by /^[Ee0-9+\-.]$/

### keepWithinRange

boolean, Default: true

This controls the value update behavior in general.- If `true` and you use the stepper or up/down arrow keys, the value will not exceed the `max` or go lower than `min`- If `false`, the value will be allowed to go out of range.

### max

double, Default: Number.MAX_SAFE_INTEGER

The maximum value of the counter

### min

double, Default: Number.MIN_SAFE_INTEGER

The minimum value of the counter

### parse

String

If using a custom display format, this converts the custom format to a format `parseFloat` understands.

### pattern

String, Default: [0-9]*(.[0-9]+)?

The pattern used to check the <input> element's value against on form submission.

### precision

integer

The number of decimal points used to round the value

### step

double, Default: 1

The step used to increment or decrement the value

### value

double

The value of the counter. Should be less than `max` and greater than `min`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the NumberInput

# NumberInput

NumberInput is a form input control that allows users to input numbers using both keyboard and mouse. It restricts users from entering non-numeric values and also provides increment and decrement buttons to adjust the value. It can be used to facilitate user input for quantities, price or other numerical values in forms.

## Properties

### allowMouseWheel

boolean

If `true`, the input's value will change based on mouse wheel

### preText

String

If set, this will be shown before the number, e.g. $ or £

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### getAriaValueText

any

This is used to format the value so that screen readerscan speak out a more human-friendly value.It is used to set the `aria-valuetext` property of the input

### id

String

The `id` to use for the number input field.

### isInvalid

boolean

If `true`, the input will have `aria-invalid` set to `true`

### isReadOnly

boolean

If `true`, the input will be in readonly mode

### isRequired

boolean

Whether the input is required

### max

double, Default: Number.MAX_SAFE_DOUBLE

The maximum value of the counter

### min

double, Default: Number.MIN_SAFE_DOUBLE

The minimum value of the counter

### parse

String

If using a custom display format, this converts the custom format to a format `parseFloat` understands.

### pattern

String, Default: [0-9]*(.[0-9]+)?

The pattern used to check the <input> element's value against on form submission.

### precision

integer

The number of decimal points used to round the value

### step

double, Default: 1

The step used to increment or decrement the value

### value

double

The value of the counter. Should be less than `max` and greater than `min`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the NumberInput

# NumberInputField

NumberInputField allows users to enter numerical values in a text field and provides increment and decrement buttons to manipulate the value. It is used when a specific numerical value needs to be inputted or adjusted with a higher level of precision.

## Properties

### allowMouseWheel

boolean

If `true`, the input's value will change based on mouse wheel

### clampValueOnBlur

boolean, Default: true

This controls the value update when you blur out of the input.- If `true` and the value is greater than `max`, the value will be reset to `max`- Else, the value remains the same.

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### focusInputOnChange

boolean, Default: true

If `true`, the input will be focused as you incrementor decrement the value with the stepper

### format

any

If using a custom display format, this converts the default format to the custom format.

### getAriaValueText

any

This is used to format the value so that screen readerscan speak out a more human-friendly value.It is used to set the `aria-valuetext` property of the input

### id

String

The `id` to use for the number input field.

### inputMode

any, Default: decimal

Hints at the type of data that might be entered by the user. It also determinesthe type of keyboard shown to the user on mobile devices

### isInvalid

boolean

If `true`, the input will have `aria-invalid` set to `true`

### isReadOnly

boolean

If `true`, the input will be in readonly mode

### isRequired

boolean

Whether the input is required

### isValidCharacter

boolean

Whether the pressed key should be allowed in the input.The default behavior is to allow DOM floating point characters defined by /^[Ee0-9+\-.]$/

### keepWithinRange

boolean, Default: true

This controls the value update behavior in general.- If `true` and you use the stepper or up/down arrow keys, the value will not exceed the `max` or go lower than `min`- If `false`, the value will be allowed to go out of range.

### max

double, Default: Number.MAX_SAFE_INTEGER

The maximum value of the counter

### min

double, Default: Number.MIN_SAFE_INTEGER

The minimum value of the counter

### parse

String

If using a custom display format, this converts the custom format to a format `parseFloat` understands.

### pattern

String, Default: [0-9]*(.[0-9]+)?

The pattern used to check the <input> element's value against on form submission.

### precision

integer

The number of decimal points used to round the value

### step

double, Default: 1

The step used to increment or decrement the value

### value

double

The value of the counter. Should be less than `max` and greater than `min`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the NumberInput

# NumberInputStepper

The NumberInputStepper control allows users to input a numeric value using a text input field and increase or decrease the value using up and down arrows. It is useful for situations where precise numeric input is required.

## Properties

### allowMouseWheel

boolean

If `true`, the input's value will change based on mouse wheel

### clampValueOnBlur

boolean, Default: true

This controls the value update when you blur out of the input.- If `true` and the value is greater than `max`, the value will be reset to `max`- Else, the value remains the same.

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### focusInputOnChange

boolean, Default: true

If `true`, the input will be focused as you incrementor decrement the value with the stepper

### format

any

If using a custom display format, this converts the default format to the custom format.

### getAriaValueText

any

This is used to format the value so that screen readerscan speak out a more human-friendly value.It is used to set the `aria-valuetext` property of the input

### id

String

The `id` to use for the number input field.

### inputMode

any, Default: decimal

Hints at the type of data that might be entered by the user. It also determinesthe type of keyboard shown to the user on mobile devices

### isInvalid

boolean

If `true`, the input will have `aria-invalid` set to `true`

### isReadOnly

boolean

If `true`, the input will be in readonly mode

### isRequired

boolean

Whether the input is required

### isValidCharacter

boolean

Whether the pressed key should be allowed in the input.The default behavior is to allow DOM floating point characters defined by /^[Ee0-9+\-.]$/

### keepWithinRange

boolean, Default: true

This controls the value update behavior in general.- If `true` and you use the stepper or up/down arrow keys, the value will not exceed the `max` or go lower than `min`- If `false`, the value will be allowed to go out of range.

### max

double, Default: Number.MAX_SAFE_DOUBLE

The maximum value of the counter

### min

double, Default: Number.MIN_SAFE_DOUBLE

The minimum value of the counter

### parse

String

If using a custom display format, this converts the custom format to a format `parseFloat` understands.

### pattern

String, Default: [0-9]*(.[0-9]+)?

The pattern used to check the <input> element's value against on form submission.

### precision

integer

The number of decimal points used to round the value

### step

double, Default: 1

The step used to increment or decrement the value

### value

double

The value of the counter. Should be less than `max` and greater than `min`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the NumberInput

# PinInput

The PinInput control is used to create a highly secure and customizable input field for entering PIN codes. It allows users to input numeric values and can be used in scenarios where a high level of security is needed, such as authentication or financial transactions.

## Properties

### numFields

integer

number of boxes to render

### autoFocus

boolean

If `true`, the pin input receives focus on mount

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### id

String

The top-level id string that will be applied to the input fields.The index of the input will be appended to this top-level id.

### isInvalid

boolean

If `true`, the pin input component is put in the invalid state

### manageFocus

boolean, Default: true

If `true`, focus will move automatically to the next input once filled

### mask

boolean

If `true`, the input's value will be masked just like `type=password`

### otp

boolean

If `true`, the pin input component signals to its fields that they shoulduse `autocomplete="one-time-code"`.

### placeholder

String

The placeholder for the pin input

### type

any

Enumerations: number, alphanumeric

The type of values the pin-input should allow

### value

String

The value of the pin input. This is the value that will be returned when the pin input is filled

### variant

String, Default: outline

Enumerations: outline, flushed, filled, unstyled

The variant of the PinInput

# PinInputField

The PinInputField control is an input field that allows users to enter a numeric pin. It consists of multiple inputs that can be controlled using the keyboard or buttons provided by the UI. It is useful for applications that require users to input secure passwords or authentication codes.

## Properties

### autoFocus

boolean

If `true`, the pin input receives focus on mount

### errorBorderColor

String

The border color when the input is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the input is focused. Use color keys in `theme.colors`

### id

String

The top-level id string that will be applied to the input fields.The index of the input will be appended to this top-level id.

### isInvalid

boolean

If `true`, the pin input component is put in the invalid state

### manageFocus

boolean, Default: true

If `true`, focus will move automatically to the next input once filled

### mask

boolean

If `true`, the input's value will be masked just like `type=password`

### otp

boolean

If `true`, the pin input component signals to its fields that they shoulduse `autocomplete="one-time-code"`.

### placeholder

String

The placeholder for the pin input

### type

any

Enumerations: number, alphanumeric

The type of values the pin-input should allow

### value

String

The value of the pin input. This is the valuethat will be returned when the pin input is filled

### variant

String, Default: outline

Enumerations: outline, flushed, filled, unstyled

The variant of the PinInput

# PopoverArrow

The PopoverArrow control is a UI component that displays a small arrow on a popover or tooltip, indicating the placement of the popover or tooltip relative to the target element. It is useful for providing visual cues to users on the positioning of a tool or message.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### arrowShadowColor

String

The `box-shadow` of the popover arrow

### arrowSize

String

The size of the popover arrow

### autoFocus

boolean, Default: true

If `true`, focus will be transferred to the first interactive elementwhen the popover opens

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the popover will close when you blur out it byclicking outside or tabbing out

### closeOnEsc

boolean, Default: true

If `true`, the popover will close when you hit the `Esc` key

### computePositionOnMount

boolean

If `true`, the popover will be positioned when it mounts(even if it's not open)Note 🚨: We don't recommend using this in a popover/menu intensive UI or pageas it might affect scrolling performance.

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### id

String

The html `id` attribute of the popover.If not provided, we generate a unique id.This `id` is also used to auto-generate the `aria-labelledby`and `aria-describedby` attributes that points to the `PopoverHeader` and `PopoverBody`

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean

Performance 🚀:If `true`, the PopoverContent rendering will be deferreduntil the popover is open.

### isOpen

boolean

If `true`, the popover will be opened in controlled mode.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of popover's content when not visible.Only works when `isLazy={true}`- "unmount": The popover's content is always unmounted when not open.- "keepMounted": The popover's content initially unmounted,but stays mounted when popover is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### returnFocusOnClose

boolean, Default: true

If `true`, focus will be returned to the element that triggers the popoverwhen it closes

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### trigger

String, Default: click

Enumerations: click, hover

The interaction that triggers the popover.`hover` - means the popover will open when you hover with mouse orfocus with keyboard on the popover trigger`click` - means the popover will open on click orpress `Enter` to `Space` on keyboard

### shadowColor

any

The color of the arrow's shadow

# PopoverBody

PopoverBody is a UI component that displays the content of a popover. It renders the body of the popover with customizable styles and properties, such as padding and alignment. It is useful for creating interactive interfaces with tooltips, menus, and dialogues.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### arrowShadowColor

String

The `box-shadow` of the popover arrow

### arrowSize

String

The size of the popover arrow

### autoFocus

boolean, Default: true

If `true`, focus will be transferred to the first interactive elementwhen the popover opens

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the popover will close when you blur out it byclicking outside or tabbing out

### closeOnEsc

boolean, Default: true

If `true`, the popover will close when you hit the `Esc` key

### computePositionOnMount

boolean

If `true`, the popover will be positioned when it mounts(even if it's not open)Note 🚨: We don't recommend using this in a popover/menu intensive UI or pageas it might affect scrolling performance.

### defaultIsOpen

boolean

If `true`, the popover will be initially opened.

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### id

String

The html `id` attribute of the popover.If not provided, we generate a unique id.This `id` is also used to auto-generate the `aria-labelledby`and `aria-describedby` attributes that points to the `PopoverHeader` and `PopoverBody`

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean

Performance 🚀:If `true`, the PopoverContent rendering will be deferreduntil the popover is open.

### isOpen

boolean

If `true`, the popover will be opened in controlled mode.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of popover's content when not visible.Only works when `isLazy={true}`- "unmount": The popover's content is always unmounted when not open.- "keepMounted": The popover's content initially unmounted,but stays mounted when popover is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### returnFocusOnClose

boolean, Default: true

If `true`, focus will be returned to the element that triggers the popoverwhen it closes

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### trigger

String, Default: click

Enumerations: click, hover

The interaction that triggers the popover.`hover` - means the popover will open when you hover with mouse orfocus with keyboard on the popover trigger`click` - means the popover will open on click orpress `Enter` to `Space` on keyboard

### shadowColor

any

The color of the arrow's shadow

# PopoverContent

The PopoverContent control is a component that displays content in a pop-up window when triggered by a user action. It provides a flexible and customizable way to add additional information or functionality to a user interface. One might use it to present additional details about an item, give context to an action, or provide an interactive menu.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### arrowShadowColor

String

The `box-shadow` of the popover arrow

### arrowSize

String

The size of the popover arrow

### autoFocus

boolean, Default: true

If `true`, focus will be transferred to the first interactive elementwhen the popover opens

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the popover will close when you blur out it byclicking outside or tabbing out

### closeOnEsc

boolean, Default: true

If `true`, the popover will close when you hit the `Esc` key

### computePositionOnMount

boolean

If `true`, the popover will be positioned when it mounts(even if it's not open)Note 🚨: We don't recommend using this in a popover/menu intensive UI or pageas it might affect scrolling performance.

### defaultIsOpen

boolean

If `true`, the popover will be initially opened.

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### id

String

The html `id` attribute of the popover.If not provided, we generate a unique id.This `id` is also used to auto-generate the `aria-labelledby`and `aria-describedby` attributes that points to the `PopoverHeader` and `PopoverBody`

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean

Performance 🚀:If `true`, the PopoverContent rendering will be deferreduntil the popover is open.

### isOpen

boolean

If `true`, the popover will be opened in controlled mode.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of popover's content when not visible.Only works when `isLazy={true}`- "unmount": The popover's content is always unmounted when not open.- "keepMounted": The popover's content initially unmounted,but stays mounted when popover is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### returnFocusOnClose

boolean, Default: true

If `true`, focus will be returned to the element that triggers the popoverwhen it closes

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### trigger

String, Default: click

Enumerations: click, hover

The interaction that triggers the popover.`hover` - means the popover will open when you hover with mouse orfocus with keyboard on the popover trigger`click` - means the popover will open on click orpress `Enter` to `Space` on keyboard

### shadowColor

any

The color of the arrow's shadow

# PopoverFooter

The PopoverFooter control is a component that provides a footer section for the Popover component. It can be used to display additional information or actions related to the popover content. Someone might use it to give users clear options for interacting with the content of the Popover without needing to close and manually interact with the content elsewhere.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### arrowShadowColor

String

The `box-shadow` of the popover arrow

### arrowSize

String

The size of the popover arrow

### autoFocus

boolean, Default: true

If `true`, focus will be transferred to the first interactive elementwhen the popover opens

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the popover will close when you blur out it byclicking outside or tabbing out

### closeOnEsc

boolean, Default: true

If `true`, the popover will close when you hit the `Esc` key

### computePositionOnMount

boolean

If `true`, the popover will be positioned when it mounts(even if it's not open)Note 🚨: We don't recommend using this in a popover/menu intensive UI or pageas it might affect scrolling performance.

### defaultIsOpen

boolean

If `true`, the popover will be initially opened.

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### id

String

The html `id` attribute of the popover.If not provided, we generate a unique id.This `id` is also used to auto-generate the `aria-labelledby`and `aria-describedby` attributes that points to the `PopoverHeader` and `PopoverBody`

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean

Performance 🚀:If `true`, the PopoverContent rendering will be deferreduntil the popover is open.

### isOpen

boolean

If `true`, the popover will be opened in controlled mode.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of popover's content when not visible.Only works when `isLazy={true}`- "unmount": The popover's content is always unmounted when not open.- "keepMounted": The popover's content initially unmounted,but stays mounted when popover is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### returnFocusOnClose

boolean, Default: true

If `true`, focus will be returned to the element that triggers the popoverwhen it closes

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### trigger

String, Default: click

Enumerations: click, hover

The interaction that triggers the popover.`hover` - means the popover will open when you hover with mouse orfocus with keyboard on the popover trigger`click` - means the popover will open on click orpress `Enter` to `Space` on keyboard

### shadowColor

any

The color of the arrow's shadow

# PopoverHeader

The PopoverHeader control is a component used to display a header for a Popover component. It typically contains a title and/or a close button. It provides a way for users to identify the type of content that will be displayed in the Popover without having to interact with it first. Users might use it to improve the accessibility and usability of their Popover components.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### arrowShadowColor

String

The `box-shadow` of the popover arrow

### arrowSize

String

The size of the popover arrow

### autoFocus

boolean, Default: true

If `true`, focus will be transferred to the first interactive elementwhen the popover opens

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the popover will close when you blur out it byclicking outside or tabbing out

### closeOnEsc

boolean, Default: true

If `true`, the popover will close when you hit the `Esc` key

### computePositionOnMount

boolean

If `true`, the popover will be positioned when it mounts(even if it's not open)Note 🚨: We don't recommend using this in a popover/menu intensive UI or pageas it might affect scrolling performance.

### defaultIsOpen

boolean

If `true`, the popover will be initially opened.

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### id

String

The html `id` attribute of the popover.If not provided, we generate a unique id.This `id` is also used to auto-generate the `aria-labelledby`and `aria-describedby` attributes that points to the `PopoverHeader` and `PopoverBody`

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean

Performance 🚀:If `true`, the PopoverContent rendering will be deferreduntil the popover is open.

### isOpen

boolean

If `true`, the popover will be opened in controlled mode.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of popover's content when not visible.Only works when `isLazy={true}`- "unmount": The popover's content is always unmounted when not open.- "keepMounted": The popover's content initially unmounted,but stays mounted when popover is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### returnFocusOnClose

boolean, Default: true

If `true`, focus will be returned to the element that triggers the popoverwhen it closes

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### trigger

String, Default: click

Enumerations: click, hover

The interaction that triggers the popover.`hover` - means the popover will open when you hover with mouse orfocus with keyboard on the popover trigger`click` - means the popover will open on click orpress `Enter` to `Space` on keyboard

### shadowColor

any

The color of the arrow's shadow

# PopoverSimple

The Popover control is a UI component that displays content in a small window that appears on top of other content. It allows users to access additional information without disrupting their workflow. It can be used to provide context or to display related options or actions.

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### arrowShadowColor

String

The `box-shadow` of the popover arrow

### arrowSize

String

The size of the popover arrow

### autoFocus

boolean, Default: true

If `true`, focus will be transferred to the first interactive elementwhen the popover opens

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the popover will close when you blur out it byclicking outside or tabbing out

### closeOnEsc

boolean, Default: true

If `true`, the popover will close when you hit the `Esc` key

### computePositionOnMount

boolean

If `true`, the popover will be positioned when it mounts(even if it's not open)Note 🚨: We don't recommend using this in a popover/menu intensive UI or pageas it might affect scrolling performance.

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### id

String

The html `id` attribute of the popover.If not provided, we generate a unique id.This `id` is also used to auto-generate the `aria-labelledby`and `aria-describedby` attributes that points to the `PopoverHeader` and `PopoverBody`

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean

Performance 🚀:If `true`, the PopoverContent rendering will be deferreduntil the popover is open.

### isOpen

boolean

If `true`, the popover will be opened in controlled mode.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of popover's content when not visible.Only works when `isLazy={true}`- "unmount": The popover's content is always unmounted when not open.- "keepMounted": The popover's content initially unmounted,but stays mounted when popover is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### returnFocusOnClose

boolean, Default: true

If `true`, focus will be returned to the element that triggers the popoverwhen it closes

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### trigger

String, Default: click

Enumerations: click, hover

The interaction that triggers the popover.`hover` - means the popover will open when you hover with mouse orfocus with keyboard on the popover trigger`click` - means the popover will open on click orpress `Enter` to `Space` on keyboard

### shadowColor

any

The color of the arrow's shadow

# PopoverTrigger

What causes the popover -  should be paired with a clickable trigger element such as button

## Properties

# PopupMessage

The PopupMessage component is a transient feedback mechanism that provides simple, short messages about an operation's status. It's used to display notifications that do not require user interaction and automatically disappear after a certain timeout.

## Properties

### duration

integer, Default: 5000

The duration in milliseconds for which the toast should be visible. A value of `0` will make the popup message remain until manually closed.

### position

String, Default: bottom

Enumerations: top, top-right, top-left, bottom, bottom-right, bottom-left

The position on the screen where the toast will appear.

### status

String, Default: info

Enumerations: info, warning, success, error

The status of the toast, which influences its icon and color scheme.

### isClosable

boolean, Default: true

If `true`, the toast will have a close button, allowing the user to dismiss it before the timeout.

### variant

String, Default: solid

Enumerations: solid, subtle, left-accent, top-accent

The visual style of the toast.

### title

String

The title of the toast message.

### description

String

A description or additional information that appears below the title in the toast.

### icon

icon

An optional icon displayed within the toast to signify the type of notification.

### value

String

unique id.  If non blank and not previously seen, the message will be shown

# Portal

The Portal control allows developers to render a component hierarchy outside of its parent tree while preserving its place in the component tree. This can be useful for creating modal dialogs, dropdown menus, and any other UI element that needs to be positioned outside of its parent container.

## Properties

### zIndex

String

[Z-Index war] If your has multiple elementswith z-index clashing, you might need to apply a z-index to the Portal manager

### appendToParentPortal

boolean, Default: true

If `true`, the portal will check if it is within a parent portaland append itself to the parent's portal node.This provides nesting for portals.If `false`, the portal will always append to `document.body`regardless of nesting. It is used to opt out of portal nesting.

### containerRef

String

The `ref` to the component where the portal will be attached to.

# PortalManager

The PortalManager control facilitates the creation of portals, allowing users to render content outside of the parent component's DOM hierarchy. It can be useful for creating modals, tooltips, and other types of overlays that need to be positioned relative to the document body rather than the parent component.

## Properties

### zIndex

String

[Z-Index war] If your has multiple elementswith z-index clashing, you might need to apply a z-index to the Portal manager

### appendToParentPortal

boolean, Default: true

If `true`, the portal will check if it is within a parent portaland append itself to the parent's portal node.This provides nesting for portals.If `false`, the portal will always append to `document.body`regardless of nesting. It is used to opt out of portal nesting.

### containerRef

String

The `ref` to the component where the portal will be attached to.

# Progress

A Progress control displays a visual representation of the progress of a task or process, allowing users to track the completion status. It can be used to indicate how much progress has been made or how much time is left until completion.

## Properties

### capIsRound

boolean, Default: false

If `true`, the cap of the progress indicator will be rounded.

### color

String

The color of the progress indicator. Use a color key in the theme object

### getValueText

String

A function that returns the desired valueText to use in place of the value

### isIndeterminate

boolean, Default: false

If `true`, the progress will be indeterminate and the `value`prop will be ignored

### max

String, Default: 100

Maximum value defining 100% progress made (must be higher than 'min')

### min

double, Default: 0

Minimum value defining 'no progress' (must be lower than 'max')

### thickness

any, Default: 10px

This defines the stroke width of the svg circle.

### trackColor

String

The color name of the progress track. Use a color key in the theme object

### value

String

Current progress (must be between min/max)

### valueText

String

The desired valueText to use in place of the value

### hasStripe

boolean, Default: false

If `true`, the progress bar will show stripe

### isAnimated

boolean, Default: false

If `true`, and hasStripe is `true`, the stripes will be animated

### variant

String

The variant of the Progress

# ProgressFilledTrack

The ProgressFilledTrack control displays a visual representation of the progress of a task or process, with a colored bar filling a track to indicate the percentage completion. It allows users to easily track progress and estimate how much is left to be done.

## Properties

### capIsRound

boolean, Default: false

If `true`, the cap of the progress indicator will be rounded.

### color

String

The color of the progress indicator. Use a color key in the theme object

### getValueText

String

A function that returns the desired valueText to use in place of the value

### isIndeterminate

boolean, Default: false

If `true`, the progress will be indeterminate and the `value`prop will be ignored

### max

String, Default: 100

Maximum value defining 100% progress made (must be higher than 'min')

### min

String, Default: 0

Minimum value defining 'no progress' (must be lower than 'max')

### thickness

any, Default: 10px

This defines the stroke width of the svg circle.

### trackColor

String

The color name of the progress track. Use a color key in the theme object

### value

String

Current progress (must be between min/max)

### valueText

String

The desired valueText to use in place of the value

### hasStripe

boolean, Default: false

If `true`, the progress bar will show stripe

### isAnimated

boolean, Default: false

If `true`, and hasStripe is `true`, the stripes will be animated

### variant

String

The variant of the Progress

# ProgressLabel

The ProgressLabel control is a visual element that displays a combination of a progress bar and a label, allowing users to see the completion progress of a task with a descriptive text. It is particularly useful for displaying status updates in an application and providing users with a more informative experience.

## Properties

### capIsRound

boolean, Default: false

If `true`, the cap of the progress indicator will be rounded.

### color

String

The color of the progress indicator. Use a color key in the theme object

### getValueText

String

A function that returns the desired valueText to use in place of the value

### isIndeterminate

boolean, Default: false

If `true`, the progress will be indeterminate and the `value`prop will be ignored

### max

double, Default: 100

Maximum value defining 100% progress made (must be higher than 'min')

### min

double, Default: 0

Minimum value defining 'no progress' (must be lower than 'max')

### thickness

any, Default: 10px

This defines the stroke width of the svg circle.

### trackColor

String

The color name of the progress track. Use a color key in the theme object

### value

String

Current progress (must be between min/max)

### valueText

String

The desired valueText to use in place of the value

### hasStripe

boolean, Default: false

If `true`, the progress bar will show stripe

### isAnimated

boolean, Default: false

If `true`, and hasStripe is `true`, the stripes will be animated

### variant

String

The variant of the Progress

# ProgressTrack

ProgressTrack is a UI component that displays progress as a series of steps or stages with optional labels and icons. It provides a visual representation of the progress made in a process or task. It helps users keep track of their progress and provides a sense of accomplishment as they move towards their goal.

## Properties

### capIsRound

boolean, Default: false

If `true`, the cap of the progress indicator will be rounded.

### color

String

The color of the progress indicator. Use a color key in the theme object

### getValueText

String

A function that returns the desired valueText to use in place of the value

### isIndeterminate

boolean, Default: false

If `true`, the progress will be indeterminate and the `value`prop will be ignored

### max

String, Default: 100

Maximum value defining 100% progress made (must be higher than 'min')

### min

double, Default: 0

Minimum value defining 'no progress' (must be lower than 'max')

### thickness

any, Default: 10px

This defines the stroke width of the svg circle.

### trackColor

String

The color name of the progress track. Use a color key in the theme object

### value

String

Current progress (must be between min/max)

### valueText

String

The desired valueText to use in place of the value

### hasStripe

boolean, Default: false

If `true`, the progress bar will show stripe

### isAnimated

boolean, Default: false

If `true`, and hasStripe is `true`, the stripes will be animated

### variant

String

The variant of the Progress

# PropertyGrid

A component that presents properties in a grid for editing, with support for various data types and configurations.

## Properties

### schema

Object

Contains a schema in json schema compatible format

### value

Object

Object with properties to be displayed in the grid

# Radio

Radio control is a GUI element that allows users to select one option out of multiple options presented in a list. Radio control can be used when a user needs to choose from a limited number of options and only one can be selected at a time. It helps to make the selection process more organized and efficient.

## Properties

### aria-describedby

String

Refers to the `id` of the element that labels the radio element.

### id

String

id assigned to input

### isFocusable

boolean, Default: false

If `true` and `isDisabled` is true, the radio will remainfocusable but not interactive.

### isInvalid

boolean, Default: false

If `true`, the radio button will be invalid. This also sets `aria-invalid` to `true`.

### isReadOnly

boolean, Default: false

If `true`, the radio will be read-only

### isRequired

boolean, Default: false

If `true`, the radio button will be required. This also sets `aria-required` to `true`.

### spacing

any, Default: 0.5rem

The spacing between the checkbox and its label text

### value

String

The value to be used in the radio button.This is the value that will be returned on form submission.

### variant

String

The variant of the Radio

### defaultValue

String

The value of the radio to be `checked`initially (in uncontrolled mode)

### isNative

boolean, Default: false

If `true`, input elements will receive`checked` attribute instead of `isChecked`.This assumes, you're using native radio inputs

# RadioGroup

RadioGroup is a UI control used to group a set of radio buttons together so that the user can select only one of them at a time. It ensures that only one option is selected from a set of options, making it ideal for forms and questionnaires where the user needs to make a single choice from multiple options.

## Properties

### aria-describedby

String

Refers to the `id` of the element that labels the radio element.

### isFocusable

boolean, Default: false

If `true` and `isDisabled` is true, the radio will remainfocusable but not interactive.

### isInvalid

boolean, Default: false

If `true`, the radio button will be invalid. This also sets `aria-invalid` to `true`.

### isReadOnly

boolean, Default: false

If `true`, the radio will be read-only

### isRequired

boolean, Default: false

If `true`, the radio button will be required. This also sets `aria-required` to `true`.

### spacing

any, Default: 0.5rem

The spacing between the checkbox and its label text

### value

String

Which value is selected

### variant

String

The variant of the Radio

### defaultValue

String

The value of the radio to be `checked`initially (in uncontrolled mode)

### isNative

boolean, Default: false

If `true`, input elements will receive`checked` attribute instead of `isChecked`.This assumes, you're using native radio inputs

# RangeSlider

RangeSlider is a UI element that allows users to select a range of values within a given range of values by dragging two endpoints on a track. It's useful for selecting a range of values for filtering or searching data.

## Properties

### icon

icon

Icon to use on slider

### iconSize

integer

Size of Icon to use on slider

### iconBgColor

String

Icon background color

### iconColor

String

icon color property

### marks

stringlist

Instructive marks to put along the slider

### tooltip

String

Tooltip to put over slider

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

double, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

double, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

double, Default: 1

The step in which increments/decrements have to be made

### variant

String

The variant of the Slider

### value

doublelist

List including the start/end range

# RangeSliderInnerTrack

The RangeSliderInnerTrack control is a user interface component that visually represents the range of values selected in a slider. It fills the space between the minimum and maximum values of the slider with a contrasting color, giving an indication of the selected range. This control can be useful in applications where users need to select a range of values within specified boundaries.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

integer

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

double, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

double, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

double, Default: 1

The step in which increments/decrements have to be made

### variant

String

The variant of the Slider

# RangeSliderMark

The RangeSliderMark control is a component that allows the selection of a range of values within a defined maximum and minimum range, with customizable markers at specific intervals. It provides a clear and interactive way for users to select a range of values within a given range, making it a useful tool for filtering or sorting data.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

integer

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

String, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

String, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

integer, Default: 1

The step in which increments/decrements have to be made

### variant

String

The variant of the Slider

# RangeSliderThumb

The RangeSliderThumb control is a component that allows users to slide through a range of values. It is used to select a specific range of values within a given range. It is ideal for applications that require certain values to be within a specific range or to limit the range of values available for selection.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

integer

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

String, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

String, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

integer, Default: 1

The step in which increments/decrements have to be made

### variant

String

The variant of the Slider

# RangeSliderTrack

The RangeSliderTrack control allows users to visually select a range of values within a given range. It provides a horizontal track with two draggable thumbs that can be moved by the user to create a range. It's useful for selecting values such as a price range or a date range.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

String

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

String, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

String, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

integer, Default: 1

The step in which increments/decrements have to be made

### variant

String

The variant of the Slider

# RequiredIndicator

The RequiredIndicator control is a visual element that indicates whether a particular form field is required or not. It displays an asterisk (*) next to the field label if the field is required, making it easier for the user to identify which fields must be filled out. This control is useful for improving form accessibility and reducing errors that might occur if users leave required fields blank.

## Properties

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### label

String

The label text used to inform users as to what information isrequested for a text field.

# ScaleFade

The ScaleFade control is a visual effect that smoothly scales and fades in/out an element on the webpage, creating an appealing and subtle animation. It can be used to draw attention to important information or simply add a touch of elegance to the website design.

## Properties

### animateOpacity

boolean, Default: true

If `true`, the opacity of the content will be animated

### delay

String

Custom `delay` definition for `enter` and `exit`

### endingHeight

any, Default: auto

The height you want the content in its expanded state.

### in

boolean

Show the component; triggers when enter or exit states

### startingHeight

any, Default: 0

The height you want the content in its collapsed state.

### transition

String

Custom `transition` definition for `enter` and `exit`

### transitionEnd

String

Custom `transitionEnd` definition for `enter` and `exit`

### unmountOnExit

boolean

If `true`, the element will unmount when `in={false}` and animation is done

### initialScale

String, Default: 0.95

The initial scale of the element

### reverse

boolean, Default: true

If `true`, the element will transition back to exit state

### offsetX

any, Default: 0

The offset on the horizontal or `x` axis

### offsetY

any, Default: 8

The offset on the vertical or `y` axis

# Select

The Select control is a form element that enables users to select an option from a pre-defined list or input values. It is particularly useful when users need to provide specific inputs or make singular selections from a list of options.

## Properties

### options

stringlist

List of all possible choices

### placeholder

String

is a way to provide a default, non-selectable option that instructs the user to make a selection from the dropdown menu.

### errorBorderColor

String

The border color when the select is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the select is focused. Use color keys in `theme.colors`

### icon

icon

The icon element to use in the select

### iconColor

String

The color of the icon

### iconSize

String

The size (width and height) of the icon

### iconBgColor

String

Icon background color

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Select

### value

String

The selected value

### size

any

See SizeEnum, size of select

# SelectField

The SelectField control is a form input component that allows users to select from a dropdown list of options. It is useful for presenting a limited number of choices to users in a clear and organized way.

## Properties

### errorBorderColor

String

The border color when the select is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the select is focused. Use color keys in `theme.colors`

### icon

icon

The icon element to use in the select

### iconColor

String

The color of the icon

### iconSize

String

The size (width and height) of the icon

### iconBgColor

String

Icon background color

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, filled, flushed, unstyled

The variant of the Select

# Show

The Show control is a component that toggles the visibility of its child elements based on a boolean input. It allows for dynamic content rendering based on user interaction or other events, providing a more interactive and responsive user experience. It might be used to show or hide elements based on user actions such as clicks on buttons or checkboxes, or to control the display of certain information based on conditional logic or data changes.

## Properties

### above

String

A value from the `breakpoints` section in the theme. Will render `children`from that breakpoint and above. Default breakpoint values: `sm`, `md`, `lg`, `xl`, `2xl`.

### below

String

A value from the `breakpoints` section in the theme. Will render `children`from that breakpoint and below. Default breakpoint values: `sm`, `md`, `lg`, `xl`, `2xl`.

### breakpoint

String

A custom css media query that determines when the `children` are rendered.Will render `children` if that query resolves to `true`.

# Sidebar

Resizing top of page bar.  Children positions EAST, CENTER, WEST

## Properties

# SimpleAccordion

Simple Accordion control, button that expands a section

## Properties

### allowToggle

boolean, Default: true

If `true`, any expanded accordion item can be collapsed again.

### defaultOpen

boolean, Default: false

If `true`, any expanded accordion item is expanded

# SimpleGrid

The SimpleGrid control is a responsive grid system that allows users to easily create and layout content in a flexible manner. It can be used to create responsive layouts that adapt to different screen sizes and device types, making it ideal for building dynamic web pages. Users might use the SimpleGrid to create a visually appealing and organized layout for their website or application.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Skeleton

The Skeleton control is a visual placeholder that helps users understand where content will be loaded on a page or component. It provides a temporary visual representation of empty or unfinished components, which mimics the expected layout and dimensions of actual data. Someone might use it to improve user experience by minimizing loading times and preventing frustrating "jumps" in the layout.

## Properties

### endColor

String

The color at the animation end

### fadeDuration

String, Default: 0.4

The fadeIn duration in seconds. Requires `isLoaded` toggled to `true` in order to see the transition.

### fitContent

boolean, Default: false

If `true`, the skeleton will take the width of it's children

### isLoaded

boolean, Default: false

If `true`, it'll render its children with a nice fade transition

### speed

String, Default: 0.8

The animation speed in seconds

### startColor

String

The color at the animation start

# SkeletonText

The SkeletonText control is a component that displays a placeholder for data while it is being loaded. It allows users to see the structure and layout of a page before the actual content is loaded, creating a smoother user experience.

## Properties

### endColor

String

The color at the animation end

### fadeDuration

String, Default: 0.4

The fadeIn duration in seconds. Requires `isLoaded` toggled to `true` in order to see the transition.

### fitContent

boolean, Default: false

If `true`, the skeleton will take the width of it's children

### isLoaded

boolean, Default: false

If `true`, it'll render its children with a nice fade transition

### speed

String, Default: 0.8

The animation speed in seconds

### startColor

String

The color at the animation start

# SkipNavContent

The SkipNavContent control is a component that allows users to skip over repetitive navigation links and directly access the main content of a page. It provides accessibility benefits by allowing users to bypass potential obstacles in navigating a webpage.

## Properties

# SkipNavLink

The SkipNavLink control is a component used to provide a functional link that allows users to skip a particular navigation element and jump to the main content of a web page. It is primarily used to improve accessibility for users who rely on screen readers or keyboard navigation.

## Properties

# Slide

The Slide control is a type of input slider that allows users to select a value within a defined range by sliding a handle along a track. It is commonly used for selecting numerical values, such as volume or brightness, and provides a visual representation of the user's selection. Users may use it when they need to select a specific value quickly and accurately.

## Properties

### animateOpacity

boolean, Default: true

If `true`, the opacity of the content will be animated

### delay

String

Custom `delay` definition for `enter` and `exit`

### endingHeight

any, Default: auto

The height you want the content in its expanded state.

### in

boolean

Show the component; triggers when enter or exit states

### startingHeight

any, Default: 0

The height you want the content in its collapsed state.

### transition

String

Custom `transition` definition for `enter` and `exit`

### transitionEnd

String

Custom `transitionEnd` definition for `enter` and `exit`

### unmountOnExit

boolean

If `true`, the element will unmount when `in={false}` and animation is done

### initialScale

String, Default: 0.95

The initial scale of the element

### reverse

boolean, Default: true

If `true`, the element will transition back to exit state

### offsetX

any, Default: 0

The offset on the horizontal or `x` axis

### offsetY

any, Default: 8

The offset on the vertical or `y` axis

# SlideFade

SlideFade is a user interface control that combines the slide-in and fade-in effects to animate the entrance and exit of a component on a web page. It provides a smooth and elegant animation transition that improves the visual appeal and user experience. One might use it to add a subtle and professional touch to their web design.

## Properties

### animateOpacity

boolean, Default: true

If `true`, the opacity of the content will be animated

### delay

String

Custom `delay` definition for `enter` and `exit`

### endingHeight

any, Default: auto

The height you want the content in its expanded state.

### in

boolean

Show the component; triggers when enter or exit states

### startingHeight

any, Default: 0

The height you want the content in its collapsed state.

### transition

String

Custom `transition` definition for `enter` and `exit`

### transitionEnd

String

Custom `transitionEnd` definition for `enter` and `exit`

### unmountOnExit

boolean

If `true`, the element will unmount when `in={false}` and animation is done

### initialScale

String, Default: 0.95

The initial scale of the element

### reverse

boolean, Default: true

If `true`, the element will transition back to exit state

### offsetX

any, Default: 0

The offset on the horizontal or `x` axis

### offsetY

any, Default: 8

The offset on the vertical or `y` axis

# Slider

A slider control is a user interface element that enables the selection of a value by sliding a thumb-like element along a horizontal or vertical track. It allows users to set and adjust a value within a given range, making it a useful tool for tasks that require precise control over values.

## Properties

### icon

icon

Icon to use on slider

### iconSize

integer

Size of Icon to use on slider

### iconBgColor

String

Icon background color

### iconColor

String

icon color property

### marks

stringlist

Instructive marks to put along the slider

### tooltip

String

Tooltip to put over slider

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

integer

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

double, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

double, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

integer, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

double, Default: 1

The step in which increments/decrements have to be made

### value

double

The value of the Slider

# SliderInnerTrack

The SliderInnerTrack is a component used to render the inner track of a slider bar. It determines the progress of the slider and visually indicates the selected value. It is useful to display a visual representation of a slider control to users.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

double, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

double, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

double, Default: 1

The step in which increments/decrements have to be made

### value

double

Value of slider

# SliderMark

SliderMark is a UI control that allows users to select a value on a range of values by dragging a slider. Users can see the range values on the slider and can also add custom markers that indicate specific values of interest. It's useful when the user needs to pick a specific value from a range.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

double, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

double, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

double, Default: 1

The step in which increments/decrements have to be made

### value

double

Value of slider

# SliderThumb

The SliderThumb control is a component that allows users to move a slider handle along a track to select a specific value within a range. It provides a visual indicator of the selected value and can be customized to fit within the design of various applications. One might use it to allow users to select a value from a range in an intuitive and customizable way.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

integer

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

double, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

double, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

double, Default: 1

The step in which increments/decrements have to be made

### value

double

The variant of the Slider

# SliderTrack

The SliderTrack control facilitates the user in selecting a value from a range of values by sliding a thumb along a track. It provides a visual representation of the value range and renders the track as per the defined orientation. Users might use it to enable the input of a value within a specific range in a more intuitive manner.

## Properties

### aria-label

String

The static string to use used for `aria-label`if no visible label is used.

### aria-labelledby

String

The static string `aria-labelledby` that points to theID of the element that serves as label for the slider

### aria-valuetext

String

The static string to use used for `aria-valuetext`

### defaultValue

integer

The initial value of the slider in uncontrolled mode

### focusThumbOnChange

boolean, Default: true

If `false`, the slider handle will not capture focus when value changes.

### getAriaValueText

String

Function that returns the `aria-valuetext` for screen readers.It is mostly used to generate a more human-readablerepresentation of the value for assistive technologies

### id

String

The base `id` to use for the slider and its components

### isReadOnly

boolean, Default: false

If `true`, the slider will be in `read-only` state

### isReversed

boolean, Default: false

If `true`, the value will be incremented or decremented in reverse.

### max

String, Default: 100

The maximum allowed value of the slider. Cannot be less than min.

### min

String, Default: 0

The minimum allowed value of the slider. Cannot be greater than max.

### minStepsBetweenThumbs

String, Default: 0

The minimum distance between slider thumbs. Useful for preventingthe thumbs from being too close together.

### orientation

String, Default: horizontal

Enumerations: horizontal, vertical

Orientation of the slider

### step

integer, Default: 1

The step in which increments/decrements have to be made

### variant

String

The variant of the Slider

# Spacer

The Spacer control is a component used to add empty space between other components in a design. It can be used to increase the visual appeal and organization of a layout or to create separation between content.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Spinner

The Spinner control is a user interface element that allows users to select a numerical value by clicking or scrolling up/down on an arrow-shaped icon. It is commonly used in forms to input or adjust numerical values quickly and accurately.

## Properties

### color

String

The color of the spinner

### emptyColor

String, Default: transparent

The color of the empty area in the spinner

### label

String, Default: Loading...

For accessibility, it is important to add a fallback loading text.This text will be visible to screen readers.

### speed

String, Default: 0.45s

The speed of the spinner.

### thickness

String, Default: 2px

The thickness of the spinner

### variant

String

The variant of the Spinner

# Square

The Square control is a pre-built component that displays a square-shaped box with customizable borders, background color, and other properties. It can be used to create simple UI elements such as buttons, icons, or avatars, or as a decorative element to add visual interest to a layout.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Stack

The Stack control arranges elements vertically in a single column and supports responsive spacing. It helps to create clean and organized layouts by stacking components on top of one another, leaving no space between them. Using Stack can simplify the process of building complex UIs and ensure consistent spacing across different screen sizes and orientations.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# StackDivider

The StackDivider control is a utility component that adds dividers between elements within a stack. It simplifies the process of adding dividers to a stack, and is ideal for organizing and spacing out content in a clear and concise manner.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Stat

The Stat control is a component that displays a numeric value with an accompanying label and optional icon. It allows users to easily visualize and communicate important statistics or metrics. It can be used in data-heavy applications or dashboards to highlight key information and provide a quick overview of data.

## Properties

### variant

String

The variant of the Stat

# StatArrow

The StatArrow control is a visual component that displays a number with an upward or downward arrow depending on whether the number has increased or decreased. It is useful for indicating changes in metrics such as sales numbers or website traffic.

## Properties

### variant

String

The variant of the Stat

# StatGroup

The StatGroup control is a component that allows you to group statistical data and display it in an organized manner. It offers a range of customizable visualizations for numerical data, including numbers, percentages, and icons. Someone might use it to create informative and visually appealing dashboards, reports, or data summaries.

## Properties

### variant

String

The variant of the Stat

# StatHelpText

The StatHelpText control is a component used to display contextual information or descriptions for data displayed in a statistical summary. It provides concise and clear explanations to help users understand the data presented. It also allows customization and styling options for users to match their design needs. It can be used to provide additional information to users in dashboard or analytics projects.

## Properties

### variant

String

The variant of the Stat

# StatLabel

The StatLabel control displays a numerical value with a label below it, and allows for customization of the label text and color. It is useful when displaying statistics or metrics in an interface.

## Properties

### variant

String

The variant of the Stat

# StatNumber

StatNumber is a customizable numerical display component that allows users to showcase a range of metric statistics and numbers in an aesthetically pleasing manner. It can be used to present important numerical data in an easy-to-read format, making it ideal for business dashboards, performance metrics, and other data visualization needs.

## Properties

### variant

String

The variant of the Stat

# StatsCard

a small vanilla status card

## Properties

### description

String

additional information to be passed to the StatsCard

### variant

String

Variant of the stats card

### qty

String

if set, use this text, if unset we will use controls value

### difference

double

if set, this is a value (or percentage) of increase

### differenceUnit

String

if difference set, this will be after it, e.g. '%'

### iconPosition

String

Enumerations: left, right

Should the main icon be left or right of the control?

### icon

icon, Default:

The checked icon to use

### iconColor

String

The color of the checkbox icon when checked or indeterminate

### iconSize

any

The size of the checkbox icon when checked or indeterminate

### iconBgColor

String

Icon background color

### iconBorderRadius

any

Icon BorderRadius, 'full' for cicle

# Step

The Step control is a component that allows users to select a value within a specified range by clicking either an increment or decrement button. It may be used to ensure input values fall within a specific range or to provide a more intuitive UX for users who prefer visual cues when selecting values.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# StepDescription

The StepDescription control is a component that provides a visual representation of the current step in a step-by-step process. It displays a brief summary of the current step and other relevant information. Someone might use it to enhance the user experience and guide them through a complex multi-step process.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# StepIndicator

The StepIndicator control is a UI component that displays a sequence of steps that a user needs to perform. It provides visual feedback on the current step and allows users to easily navigate through the steps. It can be used to guide users through a multi-step process, such as filling out a form or completing a checkout process.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# StepSeparator

The StepSeparator control allows for creating a visual separation between different steps or sections of a process or form by rendering a line with optional text labels. It can help enhance the clarity and organization of information, as well as guide users through complex workflows.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# StepStatus

StepStatus is a visual control that represents the progress of a multi-step process with various steps. It displays each completed or current step with appropriate icons and highlights the active step. It is useful for creating intuitive and clear user interfaces for multi-step processes.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# StepTitle

StepTitle is a user interface control that displays the title of a step in a multi-step process. This control helps users stay organized and informed about their progress while completing a multi-step form or process. A user might use it to guide users through a complex process or to help them keep track of their progress in a long form.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# Stepper

The Stepper control is a type of input element used to increment or decrement a numerical value in a user interface. It allows users to easily and precisely adjust values within a set range. It is useful for forms and settings pages where users need to make small adjustments to values.

## Properties

### index

String

The active step index

### orientation

String, Default: horizontal

The orientation of the stepper

### showLastSeparator

boolean

Whether to show or not the last separator while in vertical orientation

### variant

String

The variant of the Stepper

# SubMenu

The SubMenu control allows developers to create clickable submenu items

## Properties

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### autoSelect

boolean, Default: true

If `true`, the first enabled menu item will receive focus and be selectedwhen the menu opens.

### boundary

String, Default: clippingParents

Enumerations: clippingParents, scrollParent, HTMLElement

The boundary area for the popper. Used within the `preventOverflow` modifier

### closeOnBlur

boolean, Default: true

If `true`, the menu will close when you click outsidethe menu list

### closeOnSelect

boolean, Default: true

If `true`, the menu will close when a menu item isclicked

### eventListeners

boolean, Default: true

If provided, determines whether the popper will reposition itself on `scroll`and `resize` of the window.

### flip

boolean, Default: true

If `true`, the popper will change its placement and flip when it'sabout to overflow its boundary area.

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### initialFocusRef

String

The `ref` of the element that should receive focus when the popover opens.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, the MenuItem rendering will be deferreduntil the menu is open.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of menu's content when not visible.Only works when `isLazy={true}`- "unmount": The menu's content is always unmounted when not open.- "keepMounted": The menu's content initially unmounted,but stays mounted when menu is open.

### matchWidth

boolean, Default: false

If `true`, the popper will match the width of the reference at all times.It's useful for `autocomplete`, `date-picker` and `select` patterns.

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### preventOverflow

boolean, Default: true

If `true`, will prevent the popper from being cut off and ensureit's visible within the boundary area.

### strategy

String, Default: absolute

Enumerations: absolute, fixed

The CSS positioning strategy to use.

### command

String

Right-aligned label text content, useful for displaying hotkeys.

### commandSpacing

any

The spacing between the command and menu item's label.

### icon

icon

The icon to render before the menu item's label.

### iconSpacing

any

The spacing between the icon and menu item's label.

### isFocusable

boolean

If `true` and the menuitem is disabled, it'llremain keyboard-focusable

# Switch

The Switch control is a toggle button that allows users to switch between two states. It is typically used to turn on or off a setting or feature within an application or website.

## Properties

### aria-label

String

Defines the string that labels the checkbox element.

### aria-labelledby

String

Refers to the `id` of the element that labels the checkbox element.

### id

String

id assigned to input

### isFocusable

boolean, Default: false

If `true` and `isDisabled` is passed, the checkbox willremain tabbable but not interactive

### isInvalid

boolean, Default: false

If `true`, the checkbox is marked as invalid.Changes style of unchecked state.

### isReadOnly

boolean, Default: false

If `true`, the checkbox will be readonly

### isRequired

boolean, Default: false

If `true`, the checkbox input is marked as required,and `required` attribute will be added

### spacing

any, Default: 0.5rem

The spacing between the switch and its label text

### tabIndex

String

The tab-index property of the underlying input element.

### value

boolean

The value to be used in the checkbox input.This is the value that will be returned on form submission.

### variant

String

The variant of the Switch

# TabIndicator

TabIndicator is a user interface element that visually displays a list of clickable tabs and highlights the active tab. It is useful for organizing and navigating content within a single view or page.

## Properties

### defaultIndex

any

The initial index of the selected tab (in uncontrolled mode)

### index

String

The index of the selected tab (in controlled mode)

### isFitted

boolean, Default: false

If `true`, tabs will stretch to width of the tablist.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, rendering of the tab panel's will be deferred until it is selected.

### isManual

boolean, Default: false

If `true`, the tabs will be manually activated anddisplay its panel by pressing Space or Enter.If `false`, the tabs will be automatically activatedand their panel is displayed when they receive focus.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of tab panels' content when not active.Only works when `isLazy={true}`- "unmount": The content of inactive tab panels are always unmounted.- "keepMounted": The content of inactive tab panels is initially unmounted,but stays mounted when selected.

### orientation

String, Default: horizontal

Enumerations: vertical, horizontal

The orientation of the tab list.

### variant

String, Default: line

Enumerations: line, enclosed, enclosed-colored, soft-rounded, solid-rounded, unstyled

The variant of the Tabs

### clickOnEnter

boolean, Default: true

Whether or not trigger click on pressing `Enter`.

### clickOnSpace

boolean, Default: true

Whether or not trigger click on pressing `Space`.

### isFocusable

boolean, Default: false

If `true` and isDisabled, the element willhave only `aria-disabled` set to `true`

# TabList

The TabList control allows users to easily switch between different sections of content within a page or application. It organizes multiple tabs, each representing a distinct section of content, and allows users to click on them to display the associated content. It’s commonly used to create multi-step forms, navigation menus, or dashboard views.

## Properties

### tabs

stringlist

If set, this will be used for the tab names - otherwise add children to this control to add tabs

### defaultIndex

any

The initial index of the selected tab (in uncontrolled mode)

### index

String

The index of the selected tab (in controlled mode)

### isFitted

boolean, Default: false

If `true`, tabs will stretch to width of the tablist.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, rendering of the tab panel's will be deferred until it is selected.

### isManual

boolean, Default: false

If `true`, the tabs will be manually activated anddisplay its panel by pressing Space or Enter.If `false`, the tabs will be automatically activatedand their panel is displayed when they receive focus.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of tab panels' content when not active.Only works when `isLazy={true}`- "unmount": The content of inactive tab panels are always unmounted.- "keepMounted": The content of inactive tab panels is initially unmounted,but stays mounted when selected.

### orientation

String, Default: horizontal

Enumerations: vertical, horizontal

The orientation of the tab list.

### variant

String, Default: line

Enumerations: line, enclosed, enclosed-colored, soft-rounded, solid-rounded, unstyled

The variant of the Tabs

### clickOnEnter

boolean, Default: true

Whether or not trigger click on pressing `Enter`.

### clickOnSpace

boolean, Default: true

Whether or not trigger click on pressing `Space`.

### isFocusable

boolean, Default: false

If `true` and isDisabled, the element willhave only `aria-disabled` set to `true`

### selectedBgColor

String

bg color of the selected tab

### selectedColor

String

color of the selected tab

# TabPanels

TabPanels is a user interface component that allows users to toggle between multiple panels of content within a single container. It provides a visually organized way to display related information and allows users to easily access and switch between different sections of content. One might use TabPanels to present a variety of options or data points while maintaining a clean and navigable user interface design.

## Properties

### defaultIndex

any

The initial index of the selected tab (in uncontrolled mode)

### index

String

The index of the selected tab (in controlled mode)

### isFitted

boolean, Default: false

If `true`, tabs will stretch to width of the tablist.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, rendering of the tab panel's will be deferred until it is selected.

### isManual

boolean, Default: false

If `true`, the tabs will be manually activated anddisplay its panel by pressing Space or Enter.If `false`, the tabs will be automatically activatedand their panel is displayed when they receive focus.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of tab panels' content when not active.Only works when `isLazy={true}`- "unmount": The content of inactive tab panels are always unmounted.- "keepMounted": The content of inactive tab panels is initially unmounted,but stays mounted when selected.

### orientation

String, Default: horizontal

Enumerations: vertical, horizontal

The orientation of the tab list.

### variant

String, Default: line

Enumerations: line, enclosed, enclosed-colored, soft-rounded, solid-rounded, unstyled

The variant of the Tabs

### clickOnEnter

boolean, Default: true

Whether or not trigger click on pressing `Enter`.

### clickOnSpace

boolean, Default: true

Whether or not trigger click on pressing `Space`.

### isFocusable

boolean, Default: false

If `true` and isDisabled, the element willhave only `aria-disabled` set to `true`

# TabSelectControl

Used for showing either multiple tabs or a single tab.  Value select which tab(s) will be shown.

## Properties

### tabs

stringlist

If set, this will be used for the tab names

### isFitted

boolean, Default: false

If `true`, tabs will stretch to width of the tablist.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, rendering of the tab panel's will be deferred until it is selected.

### isManual

boolean, Default: false

If `true`, the tabs will be manually activated anddisplay its panel by pressing Space or Enter.If `false`, the tabs will be automatically activatedand their panel is displayed when they receive focus.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of tab panels' content when not active.Only works when `isLazy={true}`- "unmount": The content of inactive tab panels are always unmounted.- "keepMounted": The content of inactive tab panels is initially unmounted,but stays mounted when selected.

### orientation

String, Default: horizontal

Enumerations: vertical, horizontal

The orientation of the tab list.

### variant

String, Default: line

Enumerations: line, enclosed, enclosed-colored, soft-rounded, solid-rounded, unstyled

The variant of the Tabs

### clickOnEnter

boolean, Default: true

Whether or not trigger click on pressing `Enter`.

### clickOnSpace

boolean, Default: true

Whether or not trigger click on pressing `Space`.

### isFocusable

boolean, Default: false

If `true` and isDisabled, the element willhave only `aria-disabled` set to `true`

# TabSelectEntry

Basic container used in TabSelectControl.

## Properties

### tabName

String

Private name of this tab.

### tabText

String

Textual description of this tab

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

boolean

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# Table

The Table control is a user interface element that displays data in tabular form, with rows and columns representing data attributes. It allows users to easily sort, filter, and manipulate the data, making it a useful tool for visualizing and analyzing information. This control is often used in applications where large amounts of data need to be displayed and managed efficiently.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableBody

The TableBody control is a component that displays the body of a table. It is used to organize large amounts of data and present it in a structured format. It is commonly used in web applications to display data in a clear and easy-to-read manner.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableCaption

The TableCaption control is used to add a caption or title to an HTML table. It allows users to provide additional information about what the table contains, making it easier to understand and use. This can be helpful in scenarios where there are several similar tables displayed on a page.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableCell

The TableCell control is a component used for displaying data in tabular format. It allows for custom formatting of the data displayed in the table cells and supports sorting and filtering functionality. It is useful for displaying data in an organized and easily digestible way.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableColumnHeader

The TableColumnHeader control is used to display and manage headers for columns in a data table, providing users with a clear understanding of the content within each column. It allows developers to customize and style the headers according to their needs, making it easier to organize and present data effectively. Its use ensures users can easily navigate and sort the data in the table.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableContainer

The TableContainer control is a component that allows you to easily create accessible, responsive, and customizable tables inside your web application. It provides various table-related functionalities such as sorting, pagination, and filtering. This control can be used to display data in a structured and organized manner for improved readability and user experience.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableFooter

The TableFooter control is used to define the footer section of a table, typically displaying information on the total count or summary of data in the corresponding table. It can be used to enhance the user experience by providing additional context to the displayed data.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TableHead

TableHead is a component used to define the header row of a table. It is used to display column headings and provide a visual cue to the user for the content of each column. The TableHead component offers a simple and efficient way of organizing large amounts of data in an organized manner.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# TablePlus

The table component is a table that displays data.  It allows the user to sort by column, resize , pagination.  Custom controls can be used in the view.  Supports delta updates to data.

## Properties

### rowCount

integer

Sets the rowcount for pagination

### columns

Object

Optional array of column definitions, each column: { key, name, resizable: true, sortable: true }.

### sql

String

If set, will perform a sql query and display the results in the table

### selection

boolean

If set, first column will be a selection box, selecting will update _selected in the data

### data

Object

Array of objects - if set, this is used as the data for the Table

### rowHeight

integer

Height of each row

### idField

String

if set, we get the rows unique id from this row[key] field

### deleteField

String

if set, we get the rows deleted time (long) this row[key] field

### seqNumField

String

if set, we get the rows update sequence number (long) this row[key] field.  Used for delta updating.

### dataSource

String

if set, we get our delta updates from this table/datasource - e.g. a streaming table

### grouping

Object

if set, we set the default keys used for grouping/aggregating on this table

### sort

stringlist

if set, we define column keys to sort on (defaults)

### rowCss

Object

optional css to apply to this column

### groupCss

Object

optional css to apply to grouping columns

### allowEditing

boolean, Default: true

if true, data in this grid can be edited

### allowSorting

boolean, Default: true

if true, data in this grid can be sorted

### allowGrouping

boolean, Default: true

if true, the data on this table can be grouped

# TableRow

TableRow is a component that enables developers to build tables that are highly customizable and interactive. It enables them to add a row to a table with the ability to style, select and sort data present within it. Its flexibility makes it an ideal choice for developers who want to build complex tables with a wide range of features.

## Properties

### variant

String, Default: simple

Enumerations: simple, striped, unstyled

The variant of the Table

### placement

String, Default: bottom

Enumerations: bottom, top

The placement of the table caption. This sets the `caption-side` CSS attribute.

### isNumeric

boolean, Default: false

Aligns the cell content to the right

# Tabs

The Tabs control is a user interface component that allows the user to switch between different sections of content within a page or application. .

## Properties

### defaultIndex

any

The initial index of the selected tab (in uncontrolled mode)

### index

String

The index of the selected tab (in controlled mode)

### isFitted

boolean, Default: false

If `true`, tabs will stretch to width of the tablist.

### isLazy

boolean, Default: false

Performance 🚀:If `true`, rendering of the tab panel's will be deferred until it is selected.

### isManual

boolean, Default: false

If `true`, the tabs will be manually activated and display its panel by pressing Space or Enter.If `false`, the tabs will be automatically activatedand their panel is displayed when they receive focus.

### lazyBehavior

String, Default: unmount

Performance 🚀:The lazy behavior of tab panels' content when not active.Only works when `isLazy={true}`- "unmount": The content of inactive tab panels are always unmounted.- "keepMounted": The content of inactive tab panels is initially unmounted,but stays mounted when selected.

### orientation

String, Default: horizontal

Enumerations: vertical, horizontal

The orientation of the tab list.

### variant

String, Default: line

Enumerations: line, enclosed, enclosed-colored, soft-rounded, solid-rounded, unstyled

The variant of the Tabs

### clickOnEnter

boolean, Default: true

Whether or not trigger click on pressing `Enter`.

### clickOnSpace

boolean, Default: true

Whether or not trigger click on pressing `Space`.

### isFocusable

boolean, Default: false

If `true` and isDisabled, the element willhave only `aria-disabled` set to `true`

# Tag

The Tag control is a user interface element that allows the user to quickly categorize and filter content by assigning tags. It is used to improve the organization and searchability of content.

## Properties

### variant

String, Default: subtle

Enumerations: subtle, solid, outline

The variant of the Tag

# TagCloseButton

The TagCloseButton control is a small button that appears next to a tag and allows the tag to be removed when clicked. It provides an easy way for users to delete unwanted tags and refine their selections.

## Properties

### variant

String, Default: subtle

Enumerations: subtle, solid, outline

The variant of the Tag

# TagLabel

TagLabel is a UI element that displays a colored label with customizable text. It can be used to quickly and visually identify or categorize items within an interface.

## Properties

### variant

String, Default: subtle

Enumerations: subtle, solid, outline

The variant of the Tag

# TemplateValues

Holds a dictionary/map that can be used by other controls via {{key}} replacement

## Properties

### value

any

This will hold key/values which can be looked up in other controls via {{key}} moustache

### template

any

Chooses a template to use

# Text

The Text control allows users to display text on a web page with various customizable styling options such as font size, color, and alignment. It is often used to provide information or instructions to users.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# TextArea

Textarea is a standard HTML element used for multiline input of text. It allows users to input and edit text that spans over multiple lines. It can be used in forms, surveys, feedback systems, and any other application that requires user input with a longer amount of text.

## Properties

### errorBorderColor

String

The border color when the textarea is invalid. Use color keys in `theme.colors`

### focusBorderColor

String

The border color when the textarea is focused. Use color keys in `theme.colors`

### isInvalid

boolean, Default: false

If `true`, the form control will be invalid. This has 2 side effects:- The `FormLabel` and `FormErrorIcon` will have `data-invalid` set to `true`- The form element (e.g, Input) will have `aria-invalid` set to `true`

### isReadOnly

boolean, Default: false

If `true`, the form control will be readonly

### isRequired

boolean, Default: false

If `true`, the form control will be required. This has 2 side effects:- The `FormLabel` will show a required indicator- The form element (e.g, Input) will have `aria-required` set to `true`

### variant

String, Default: outline

Enumerations: outline, flushed, filled, unstyled

The variant of the Textarea

# TextContainer

The Container control is a layout component that helps structure content in a web page by centering it within a fixed width container with padding on the sides. It makes it easier to maintain consistent spacing and alignment between elements. Someone might use it for creating a simple and organized web page layout.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# ThemeState

Used for optionally overriding themes or parts of themes, setValue to give an override

## Properties

### mode

String

Enumerations: add, override

Standard is add, any overrides will add/update previous theme.  Override will only use this definition

### theme

String

if multiple themes are available, this will select the subtheme

### customControls

Object

contains javascript and css of custom controls

# Toast

The Toast control is a notification system that displays temporary messages to the user at the bottom or top of the screen. It can be used to alert users of important updates or actions, without disrupting their workflow.

## Properties

### component

String, Default: ToastComponent

Are you looking for a way to style the toast? Use a custom `Alert` variant in the theme.This property overrides the default ToastComponent with your own implementation.

### defaultOptions

String

Default options for `useToast(options)`

### motionVariants

String

Customize the default motion config to animate the toasts your way

### toastSpacing

any, Default: 0.5rem

Define the margin between toasts

### containerStyle

String

Optional style overrides for the container wrapping the toast component.

### description

any

The description of the toast

### duration

String, Default: 5000 ( = 5000ms )

The delay before the toast hides (in milliseconds)If set to `null`, toast will never dismiss.

### icon

any

A custom icon that will be displayed by the toast.

### id

String

The `id` of the toast.Mostly used when you need to prevent duplicate.By default, we generate a unique `id` for each toast

### isClosable

boolean, Default: false

If `true`, toast will show a close button

### position

String, Default: bottom

The placement of the toast

### render

String

Render a component toast component.Any component passed will receive 2 props: `id` and `onClose`.

### status

String

Enumerations: info, warning, success, error, loading

The status of the toast.

### title

any

The title of the toast

# ToastProvider

The ToastProvider control is a component that provides a customizable way to display short messages or notifications to the user. It can be used to alert the user to important information or updates in a user interface.

One might use the ToastProvider control to provide timely updates or alerts to the user without disrupting their workflow or requiring them to navigate to a separate page or section of the platform.

## Properties

### component

String, Default: ToastComponent

Are you looking for a way to style the toast? Use a custom `Alert` variant in the theme.This property overrides the default ToastComponent with your own implementation.

### defaultOptions

String

Default options for `useToast(options)`

### motionVariants

String

Customize the default motion config to animate the toasts your way

### toastSpacing

any, Default: 0.5rem

Define the margin between toasts

### containerStyle

String

Optional style overrides for the container wrapping the toast component.

### description

any

The description of the toast

### duration

String, Default: 5000 ( = 5000ms )

The delay before the toast hides (in milliseconds)If set to `null`, toast will never dismiss.

### icon

any

A custom icon that will be displayed by the toast.

### id

String

The `id` of the toast.Mostly used when you need to prevent duplicate.By default, we generate a unique `id` for each toast

### isClosable

boolean, Default: false

If `true`, toast will show a close button

### position

String, Default: bottom

The placement of the toast

### render

String

Render a component toast component.Any component passed will receive 2 props: `id` and `onClose`.

### status

String

Enumerations: info, warning, success, error, loading

The status of the toast.

### title

any

The title of the toast

# TooltipDefaults

A Tooltip control is a small pop-up window that displays additional information when a user hovers or clicks on an interactive element. This control sets the default look and feel for any child tooltip.  This element allows the use of setTooltip on a child element to show a tooltip.

## Properties

### aria-label

String

The accessible, human friendly label to use forscreen readers.If passed, tooltip will show the content `label`but expose only `aria-label` to assistive technologies

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### closeDelay

String, Default: 0ms

Delay (in ms) before hiding the tooltip

### closeOnClick

boolean, Default: true

If `true`, the tooltip will hide on click

### closeOnEsc

boolean, Default: true

If `true`, the tooltip will hide on pressing Esc key

### closeOnMouseDown

boolean

If `true`, the tooltip will hide while the mouse is down

### closeOnPointerDown

boolean, Default: true

If `true`, the tooltip will hide while the pointer is down

### defaultIsOpen

boolean, Default: false

If `true`, the tooltip will be initially shown

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### hasArrow

boolean, Default: false

If `true`, the tooltip will show an arrow tip

### isOpen

boolean, Default: false

If `true`, the tooltip will be shown (in controlled mode)

### label

any

The label of the tooltip

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### openDelay

String, Default: 0ms

Delay (in ms) before showing the tooltip

### placement

String, Default: bottom

Enumerations: auto-start, auto, auto-end, top-start, top, top-end, right-start, right, right-end, bottom-start, bottom, bottom-end, left-start, left, left-end

The placement of the popper relative to its reference.

### shouldWrapChildren

boolean, Default: false

If `true`, the tooltip will wrap its children in a span with `tabIndex=0`

### id

String

Custom `id` to use in place of `uuid`

# TreeNode

A TreeNode is a generic tree item that may contain children. The Node is rendered differently depending on which control it is bound to.  Used in sidbars, tree structures etc

## Properties

### iconSpacing

any

The space between the button icon and label.

### isActive

boolean, Default: false

If `true`, the button will be styled in its active state.

### isLoading

boolean, Default: false

If `true`, the button will show a spinner.

### leftIcon

icon

If added, the button will show an icon before the button's label.

### loadingText

any

The label to show in the button when `isLoading` is trueIf no text is passed, it only shows the spinner

### rightIcon

icon

If added, the button will show an icon after the button's label.

### spinner

icon

Replace the spinner component when `isLoading` is set to `true`

### spinnerPlacement

String, Default: start

Enumerations: start, end

It determines the placement of the spinner when isLoading is true

### variant

String, Default: solid

Enumerations: ghost, outline, solid, link, unstyled

The variant of the Button

### isAttached

boolean, Default: false

If `true`, the borderRadius of button that are direct children will be alteredto look flushed together

### spacing

any, Default: '0.5rem'

The spacing between the buttons

### aria-label

String

A11y: A label that describes the button

### icon

icon

The icon to be used in the button.

### isRound

boolean, Default: false

If `true`, the button will be perfectly round. Else, it'll be slightly round

### isRound

boolean, Default: false

If `true`, the button will be perfectly round. Else, it'll be slightly round

# Uploader

Component that allows the user to upload to the server

## Properties

### accept

String, Default: *

Sets the types of files that are accepted.  Default accept all

### acceptMedia

boolean

If set true, override to allow uploading audio/video files

### multiple

boolean, Default: true

if true, allows multiple files to be uploaded

### maxSizeBytes

long

maximum size in bytes that can be uploadd (client side check)

### maxFiles

integer

Maximum number of files that can be uploaded

### submitButtonText

String

Text to put on submit button.  Respects moustache templating

### addFilesText

String

Text to put on add files section. e.g. Drag Files or Click to Browse.  Respects moustache templating

# UseTooltip

The UseTooltip control is a hook that allows you to easily add tooltips to your application. It provides a simple way to create customized and interactive tooltips that can be triggered by different events or actions. The user might use this control to enhance user experience by providing additional information or context about specific elements in the UI.

## Properties

### aria-label

String

The accessible, human friendly label to use forscreen readers.If passed, tooltip will show the content `label`but expose only `aria-label` to assistive technologies

### arrowPadding

String, Default: 8

The padding required to prevent the arrow fromreaching the very edge of the popper.

### closeDelay

String, Default: 0ms

Delay (in ms) before hiding the tooltip

### closeOnClick

boolean, Default: true

If `true`, the tooltip will hide on click

### closeOnEsc

boolean, Default: true

If `true`, the tooltip will hide on pressing Esc key

### closeOnMouseDown

boolean

If `true`, the tooltip will hide while the mouse is down

### closeOnPointerDown

boolean, Default: true

If `true`, the tooltip will hide while the pointer is down

### defaultIsOpen

boolean, Default: false

If `true`, the tooltip will be initially shown

### gutter

String, Default: 8

The distance or margin between the reference and popper.It is used internally to create an `offset` modifier.NB: If you define `offset` prop, it'll override the gutter.

### hasArrow

boolean, Default: false

If `true`, the tooltip will show an arrow tip

### isOpen

boolean, Default: false

If `true`, the tooltip will be shown (in controlled mode)

### label

any

The label of the tooltip

### modifiers

String

Array of popper.js modifiers. Check the docs to seethe list of possible modifiers you can pass.

### offset

String

The main and cross-axis offset to displace popper elementfrom its reference element.

### openDelay

String, Default: 0ms

Delay (in ms) before showing the tooltip

### placement

String, Default: bottom

The placement of the popper relative to its reference.

### shouldWrapChildren

boolean, Default: false

If `true`, the tooltip will wrap its childrenin a span with `tabIndex=0`

### id

String

Custom `id` to use in place of `uuid`

# VStack

Vertical stacking component

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

# WrapItem

The WrapItem control arranges its child elements in a horizontal or vertical grid, automatically wrapping them to the next line when the container space is exhausted. It enables designers to create flexible and responsive layouts that can accommodate varying amounts of content.

## Properties

### ratio

enum

The aspect ratio of the Box. Common values are:`21/9`, `16/9`, `9/16`, `4/3`, `1.85/1`

### variant

String, Default: subtle

Enumerations: solid, subtle, outline

The variant of the Badge

### centerContent

boolean, Default: false

If `true`, the content will be centered in the square

### basis

enum

Shorthand for `flexBasis` style prop

### grow

enum

Shorthand for `flexGrow` style prop

### shrink

enum

Shorthand for `flexShrink` style prop

### wrap

enum

Shorthand for `flexWrap` style prop

### autoColumns

any

Shorthand prop for `gridAutoColumns`

### autoFlow

enum

Shorthand prop for `gridAutoFlow`

### autoRows

any

Shorthand prop for `gridAutoRows`

### column

enum

Shorthand prop for `gridColumn`

### columnGap

any

Shorthand prop for `gridColumnGap`

### gap

any

Shorthand prop for `gridGap`

### row

enum

Shorthand prop for `gridRow`

### rowGap

any

Shorthand prop for `gridRowGap`

### templateAreas

enum

Shorthand prop for `gridTemplateAreas`

### templateColumns

any

Shorthand prop for `gridTemplateColumns`

### templateRows

any

Shorthand prop for `gridTemplateRows`

### area

enum

Shorthand prop for `gridArea`

### colSpan

enum

The number of columns the grid item should `span`.

### colStart

enum

The column number the grid item should start.

### isExternal

boolean, Default: false

If `true`, the link will open in new tab

### spacing

any

The space between each list item

### stylePosition

enum

Shorthand prop for `listStylePosition`

### styleType

enum

Shorthand prop for `listStyleType`

### columns

enum

The number of columns

### minChildWidth

any

The width at which child elements will break into columns. Pass a number for pixel values or a string for any other valid CSS length.

### spacingX

any

The column gap between the grid items

### spacingY

any

The row gap between the grid items

### divider

icon

If `true`, each stack item will show a divider

### isInline

boolean, Default: false

If `true` the items will be stacked horizontally.

### shouldWrapChildren

boolean, Default: false

If `true`, the children will be wrapped in a `Box` with`display: inline-block`, and the `Box` will take the spacing props

### casing

enum

The CSS `text-transform` property

### decoration

any

The CSS `text-decoration` property

