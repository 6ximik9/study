using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace LB5_2_
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }
        
            
        private void Form1_MouseClick(object sender, MouseEventArgs e)
        {
            Random rand = new Random();
            int dx = rand.Next(1,20);
            int dy = rand.Next(5, 40);
            Button b = new Button();
            b.Parent = this;
            b.Location = new Point(dx, dy);
        
        }
    }
}
