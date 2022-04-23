f = function(x) { exp(2*x) }
message("Starting...")
n = as.integer(readline(prompt = "Pick the number of partition points: "))
methods = c("left rectangles", "right rectangles", "midpoints", "random points")
message("Available methods:")
for (i in 1:4) {
  message(i, ") ", methods[i], sep="")
}
method = readline(prompt = "Choose a method: ")

s = 0
a = -1
b = 0
h = (b-a)/n

plot(f, -1, 0)
for (i in 1:n) {
  x_i = a + (b-a)*(i/n)
  x_j = a + (b-a)*((i-1)/n)
  f_i = switch(method,
               "1" = f(x_j),
               "2" = f(x_i),
               "3" = f((x_j + x_i)/2),
               "4" = f(runif(1, x_j, x_i))
  )  
  rect(xright = x_j, xleft = x_i, ybottom = 0, ytop = f_i, col = "cyan")
  s = s + f_i
}
s = s*h

f_c = 1/2 - 1/(2*exp(2))

message("h = ", h)
message("|f-s| = ", abs(f_c - s))
message("s = ", s)
# s = 0