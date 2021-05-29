package raytracer

class Projectile(val position: Point, val velocity: Vector)

class Environment(val gravity: Vector, val wind: Vector)

def tick(environment: Environment, projectile: Projectile): Projectile = Projectile(
  projectile.position + projectile.velocity,
  projectile.velocity + environment.gravity + environment.wind
)

@main def projectileApp: Unit =
  val position = Point(0, 1, 0)
  val velocity = Vector(1, 1, 0).normalized
  val gravity = Vector(0, -0.1, 0)
  val wind = Vector(-0.01, 0, 0)
  
  val environment = Environment(gravity, wind)
  var projectile = Projectile(position, velocity)  

  while projectile.position.y > 0 do {
    println(s"Projectile position: ${projectile.position}")
    projectile = tick(environment, projectile)
  }